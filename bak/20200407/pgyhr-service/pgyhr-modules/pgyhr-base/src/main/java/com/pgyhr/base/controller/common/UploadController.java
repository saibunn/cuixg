package com.pgyhr.base.controller.common;

import com.pgyhr.core.common.utils.Base64DecodeMultipartFile;
import com.pgyhr.core.common.utils.QiniuUtil;
import com.pgyhr.core.common.utils.ResultUtil;
import com.pgyhr.core.common.vo.Result;
import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;

/**
 * @author cuixg
 * @title: UploadController
 * @projectName pgyhr-module
 * @description: todo
 * @date 2020/4/3  11:33
 */
@Slf4j
@RestController
@Api(description = "文件上传接口")
@RequestMapping("/pgyhr/upload")
@Transactional
public class UploadController {

    @Autowired
    private QiniuUtil qiniuUtil;

    @RequestMapping(value = "/file",method = RequestMethod.POST)
    @ApiOperation(value = "文件上传")
    public Result<Object> upload(@RequestParam(required = false) MultipartFile file,
                                 @RequestParam(required = false) String base64,
                                 HttpServletRequest request) {

        if(StrUtil.isNotBlank(base64)){
            // base64上传
            file = Base64DecodeMultipartFile.base64Convert(base64);
        }
        String result = null;
        String fileName = qiniuUtil.renamePic(file.getOriginalFilename());
        try {
            InputStream inputStream = file.getInputStream();
            //上传七牛云服务器
            result = qiniuUtil.qiniuInputStreamUpload(inputStream,fileName);
        } catch (Exception e) {
            log.error(e.toString());
            return ResultUtil.error(e.toString());
        }

        return ResultUtil.data(result);
    }
}
