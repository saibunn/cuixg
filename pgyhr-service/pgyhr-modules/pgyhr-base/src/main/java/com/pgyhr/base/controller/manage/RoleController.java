package com.pgyhr.base.controller.manage;

import com.pgyhr.core.common.redis.RedisTemplateHelper;
import com.pgyhr.core.common.utils.PageUtil;
import com.pgyhr.core.common.utils.ResultUtil;
import com.pgyhr.core.common.vo.PageVo;
import com.pgyhr.core.common.vo.Result;
import com.pgyhr.core.service.RoleDepartmentService;
import com.pgyhr.core.service.RolePermissionService;
import com.pgyhr.core.service.RoleService;
import com.pgyhr.core.service.UserRoleService;
import com.pgyhr.core.entity.Role;
import com.pgyhr.core.entity.RoleDepartment;
import com.pgyhr.core.entity.RolePermission;
import com.pgyhr.core.entity.UserRole;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * @author cuixg
 * @title: RoleController
 * @projectName pgyhr-module
 * @description: todo
 * @date 2020/4/3  11:33
 */
@Slf4j
@RestController
@Api(description = "角色管理接口")
@RequestMapping("/pgyhr/role")
@Transactional
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RolePermissionService rolePermissionService;

    @Autowired
    private RoleDepartmentService roleDepartmentService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RedisTemplateHelper redisTemplateHelper;

    @RequestMapping(value = "/getAllList",method = RequestMethod.GET)
    @ApiOperation(value = "获取全部角色")
    public Result<Object> roleGetAll(){

        List<Role> list = roleService.getAll();
        return ResultUtil.data(list);
    }

    @RequestMapping(value = "/getAllByPage",method = RequestMethod.GET)
    @ApiOperation(value = "分页获取角色")
    public Result<Page<Role>> getRoleByPage(PageVo page){

        Page<Role> list = roleService.findAll(PageUtil.initPage(page));
        for(Role role : list.getContent()){
            // 角色拥有权限
            List<RolePermission> permissions = rolePermissionService.findByRoleId(role.getId());
            role.setPermissions(permissions);
            // 角色拥有数据权限
            List<RoleDepartment> departments = roleDepartmentService.findByRoleId(role.getId());
            role.setDepartments(departments);
        }
        return new ResultUtil<Page<Role>>().setData(list);
    }

    @RequestMapping(value = "/setDefault",method = RequestMethod.POST)
    @ApiOperation(value = "设置或取消默认角色")
    public Result<Object> setDefault(@RequestParam String id,
                                     @RequestParam Boolean isDefault){

        Role role = roleService.get(id);
        if(role==null){
            return ResultUtil.error("角色不存在");
        }
        role.setDefaultRole(isDefault);
        roleService.update(role);
        return ResultUtil.success("设置成功");
    }

    @RequestMapping(value = "/editRolePerm",method = RequestMethod.POST)
    @ApiOperation(value = "编辑角色分配菜单权限")
    public Result<Object> editRolePerm(@RequestParam String roleId,
                                       @RequestParam(required = false) String[] permIds){

        //删除其关联权限
        rolePermissionService.deleteByRoleId(roleId);
        //分配新权限
        for(String permId : permIds){
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(roleId);
            rolePermission.setPermissionId(permId);
            rolePermissionService.save(rolePermission);
        }
        //手动批量删除缓存
        Set<String> keysUser = redisTemplateHelper.keys("user:" + "*");
        redisTemplate.delete(keysUser);
        Set<String> keysUserRole = redisTemplateHelper.keys("userRole:" + "*");
        redisTemplate.delete(keysUserRole);
        Set<String> keysUserPerm = redisTemplateHelper.keys("userPermission:" + "*");
        redisTemplate.delete(keysUserPerm);
        Set<String> keysUserMenu = redisTemplateHelper.keys("permission::userMenuList:*");
        redisTemplate.delete(keysUserMenu);
        return ResultUtil.data(null);
    }

    @RequestMapping(value = "/editRoleDep",method = RequestMethod.POST)
    @ApiOperation(value = "编辑角色分配数据权限")
    public Result<Object> editRoleDep(@RequestParam String roleId,
                                      @RequestParam Integer dataType,
                                      @RequestParam(required = false) String[] depIds){

        Role r = roleService.get(roleId);
        r.setDataType(dataType);
        roleService.update(r);
        // 删除其关联数据权限
        roleDepartmentService.deleteByRoleId(roleId);
        // 分配新数据权限
        for(String depId : depIds){
            RoleDepartment roleDepartment = new RoleDepartment();
            roleDepartment.setRoleId(roleId);
            roleDepartment.setDepartmentId(depId);
            roleDepartmentService.save(roleDepartment);
        }
        // 手动删除相关缓存
        Set<String> keys = redisTemplateHelper.keys("department:" + "*");
        redisTemplate.delete(keys);
        Set<String> keysUserRole = redisTemplateHelper.keys("userRole:" + "*");
        redisTemplate.delete(keysUserRole);

        return ResultUtil.data(null);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ApiOperation(value = "保存数据")
    public Result<Role> save(Role role){

        Role r = roleService.save(role);
        return new ResultUtil<Role>().setData(r);
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ApiOperation(value = "更新数据")
    public Result<Role> edit(Role entity){

        Role r = roleService.update(entity);
        //手动批量删除缓存
        Set<String> keysUser = redisTemplateHelper.keys("user:" + "*");
        redisTemplate.delete(keysUser);
        Set<String> keysUserRole = redisTemplateHelper.keys("userRole:" + "*");
        redisTemplate.delete(keysUserRole);
        return new ResultUtil<Role>().setData(r);
    }

    @RequestMapping(value = "/delAllByIds/{ids}",method = RequestMethod.DELETE)
    @ApiOperation(value = "批量通过ids删除")
    public Result<Object> delByIds(@PathVariable String[] ids){

        for(String id:ids){
            List<UserRole> list = userRoleService.findByRoleId(id);
            if(list!=null&&list.size()>0){
                return ResultUtil.error("删除失败，包含正被用户使用关联的角色");
            }
        }
        for(String id:ids){
            roleService.delete(id);
            //删除关联菜单权限
            rolePermissionService.deleteByRoleId(id);
            //删除关联数据权限
            roleDepartmentService.deleteByRoleId(id);
        }
        return ResultUtil.success("批量通过id删除数据成功");
    }

}
