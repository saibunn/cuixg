package com.pgyhr.base.utils;

import com.pgyhr.base.vo.MenuVo;
import com.pgyhr.core.entity.Permission;
import cn.hutool.core.bean.BeanUtil;

/**
 * @author cuixg
 * @title: VoUtil
 * @projectName pgyhr-module
 * @description: todo
 * @date 2020/4/3  11:33
 */
public class VoUtil {

    public static MenuVo permissionToMenuVo(Permission p){

        MenuVo menuVo = new MenuVo();
        BeanUtil.copyProperties(p, menuVo);
        return menuVo;
    }
}
