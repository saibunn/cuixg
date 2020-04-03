package com.pgyhr.your.controller;

import com.pgyhr.core.common.utils.PageUtil;
import com.pgyhr.core.common.utils.ResultUtil;
import com.pgyhr.core.common.vo.PageVo;
import com.pgyhr.core.common.vo.Result;
import com.pgyhr.your.entity.Student;
import com.pgyhr.your.service.IStudentService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author cuixg
 * @title: StudentController
 * @projectName pgyhr-module
 * @description: todo
 * @date 2020/4/3  11:33
 */
@Slf4j
@RestController
@Api(description = "测试管理接口")
@RequestMapping("/pgyhr/student")
@Transactional
public class StudentController {

    @Autowired
    private IStudentService iStudentService;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "通过id获取")
    public Result<Student> get(@PathVariable String id){

        Student student = iStudentService.getById(id);
        return new ResultUtil<Student>().setData(student);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ApiOperation(value = "获取全部数据")
    public Result<List<Student>> getAll(){

        List<Student> list = iStudentService.list();
        return new ResultUtil<List<Student>>().setData(list);
    }

    @RequestMapping(value = "/getByPage", method = RequestMethod.GET)
    @ApiOperation(value = "分页获取")
    public Result<IPage<Student>> getByPage(PageVo page){

        IPage<Student> data = iStudentService.page(PageUtil.initMpPage(page));
        return new ResultUtil<IPage<Student>>().setData(data);
    }

    @RequestMapping(value = "/insertOrUpdate", method = RequestMethod.POST)
    @ApiOperation(value = "编辑或更新数据")
    public Result<Student> saveOrUpdate(Student student){

        if(iStudentService.saveOrUpdate(student)){
            return new ResultUtil<Student>().setData(student);
        }
        return new ResultUtil<Student>().setErrorMsg("操作失败");
    }

    @RequestMapping(value = "/delByIds/{ids}", method = RequestMethod.DELETE)
    @ApiOperation(value = "批量通过id删除")
    public Result<Object> delAllByIds(@PathVariable String[] ids){

        for(String id : ids){
            iStudentService.removeById(id);
        }
        return ResultUtil.success("批量通过id删除数据成功");
    }
}
