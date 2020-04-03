package com.pgyhr.base.controller.manage;

import com.pgyhr.core.common.utils.PageUtil;
import com.pgyhr.core.common.utils.ResultUtil;
import com.pgyhr.core.common.vo.PageVo;
import com.pgyhr.core.common.vo.Result;
import com.pgyhr.core.common.vo.SearchVo;
import com.pgyhr.core.entity.Log;
import com.pgyhr.core.entity.elasticsearch.EsLog;
import com.pgyhr.core.service.LogService;
import com.pgyhr.core.service.elasticsearch.EsLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


/**
 * @author cuixg
 * @title: LogController
 * @projectName pgyhr-module
 * @description: todo
 * @date 2020/4/3  11:33
 */
@Slf4j
@RestController
@Api(description = "日志管理接口")
@RequestMapping("/pgyhr/log")
@Transactional
public class LogController{

    @Value("${pgyhr.logRecord.es:false}")
    private Boolean esRecord;

    @Autowired
    private EsLogService esLogService;

    @Autowired
    private LogService logService;

    @RequestMapping(value = "/getAllByPage", method = RequestMethod.GET)
    @ApiOperation(value = "分页获取全部")
    public Result<Object> getAllByPage(@RequestParam(required = false) Integer type,
                                       @RequestParam String key,
                                       SearchVo searchVo,
                                       PageVo pageVo){

        if(esRecord){
            Page<EsLog> es = esLogService.findByConfition(type, key, searchVo, PageUtil.initPage(pageVo));
            return ResultUtil.data(es);
        }else{
            Page<Log> log = logService.findByConfition(type, key, searchVo, PageUtil.initPage(pageVo));
            return ResultUtil.data(log);
        }
    }

    @RequestMapping(value = "/delByIds/{ids}", method = RequestMethod.DELETE)
    @ApiOperation(value = "批量删除")
    public Result<Object> delByIds(@PathVariable String[] ids){

        for(String id : ids){
            if(esRecord){
                esLogService.deleteLog(id);
            }else{
                logService.delete(id);
            }
        }
        return ResultUtil.success("删除成功");
    }

    @RequestMapping(value = "/delAll", method = RequestMethod.DELETE)
    @ApiOperation(value = "全部删除")
    public Result<Object> delAll(){

        if(esRecord){
            esLogService.deleteAll();
        }else{
            logService.deleteAll();
        }
        return ResultUtil.success("删除成功");
    }
}
