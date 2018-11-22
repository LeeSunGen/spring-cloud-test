package com.itmuch.cloud.study.order.controller;

import com.itmuch.cloud.study.common.base.BaseController;
import com.itmuch.cloud.study.common.base.Result;
import com.itmuch.cloud.study.common.base.Results;
import com.itmuch.cloud.study.common.oss.CloudStorageConfig;
import com.itmuch.cloud.study.common.oss.OSSFactory;
import com.itmuch.cloud.study.common.oss.UploadCloudReq;
import com.itmuch.cloud.study.common.util.Constant;
import com.itmuch.cloud.study.common.validator.ValidatorUtils;
import com.itmuch.cloud.study.common.validator.group.AliyunGroup;
import com.itmuch.cloud.study.common.validator.group.QcloudGroup;
import com.itmuch.cloud.study.common.validator.group.QiniuGroup;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Api(tags = "1.3", description = "云存储服务", value = "云存储服务")
public class SysOssController extends BaseController {


    @PostMapping("/saveConfig")
    public Result<String> saveConfig(@RequestBody UploadCloudReq uploadCloudReq){
        //上传文件
        String suffix = uploadCloudReq.getFile().getOriginalFilename().substring(uploadCloudReq.getFile().getOriginalFilename().lastIndexOf("."));
        String url = null;
        try {
            url = OSSFactory.build(uploadCloudReq.getType()).uploadSuffix(uploadCloudReq.getFile().getBytes(), suffix);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(url);
        return Results.newSuccessResult(url);
    }
}
