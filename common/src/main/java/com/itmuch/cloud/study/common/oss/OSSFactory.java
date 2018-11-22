

package com.itmuch.cloud.study.common.oss;

import com.itmuch.cloud.study.common.util.ConfigUtil;
import com.itmuch.cloud.study.common.util.Constant;
import sun.security.krb5.Config;

/**
 * 文件上传Factory
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-26 10:18
 */
public final class OSSFactory {

    public static CloudStorageService build(Integer type){


        if(type == Constant.CloudService.QINIU.getValue()){
//            return new QiniuCloudStorageService(config);
        }else if(type == Constant.CloudService.ALIYUN.getValue()){
            CloudStorageConfig cloudStorageConfig = new CloudStorageConfig();
            cloudStorageConfig.setAliyunPrefix(ConfigUtil.ALIYUN_PREFIX);
            cloudStorageConfig.setAliyunEndPoint(ConfigUtil.ALIYUN_END_POINT);
            cloudStorageConfig.setAliyunDomain(ConfigUtil.ALIYUN_DOMAIN);
            cloudStorageConfig.setAliyunBucketName(ConfigUtil.ALIYUN_BUCKET_NAME);
            cloudStorageConfig.setAliyunAccessKeySecret(ConfigUtil.ALIYUN_ACCESS_SECRET);
            cloudStorageConfig.setAliyunAccessKeyId(ConfigUtil.ALIYUN_ACCESS_KEY_ID);

            return new AliyunCloudStorageService(cloudStorageConfig);
        }else if(type == Constant.CloudService.QCLOUD.getValue()){
//            return new QcloudCloudStorageService(config);
        }

        return null;
    }

}
