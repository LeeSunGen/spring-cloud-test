package com.itmuch.cloud.study.order.controller.test;

import com.alibaba.fastjson.JSON;
import com.itmuch.cloud.study.common.oss.UploadCloudReq;
import com.itmuch.cloud.study.common.util.Constant;
import com.itmuch.cloud.study.order.controller.SysOssController;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysOssControllerTest {

    @Autowired
    private SysOssController sysOssController;

    @Test
    public void upload(){
        UploadCloudReq uploadCloudReq = new UploadCloudReq();
        uploadCloudReq.setType(Constant.CloudService.ALIYUN.getValue());

        try {
            File file = ResourceUtils.getFile("classpath:static/my5.jpg");
            FileInputStream input = new FileInputStream(file);
            MultipartFile multipartFile = new MockMultipartFile("file", file.getName(), "text/plain", IOUtils.toByteArray(input));
            uploadCloudReq.setFile(multipartFile);
            System.out.println(JSON.toJSONString(sysOssController.saveConfig(uploadCloudReq)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
