package com.itmuch.cloud.study.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * 常见错误枚举
 *
 * @author xierongli
 * @version $$Id: project-system, v 0.1 2018/6/11 上午10:54 mark1xie Exp $$
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorCodeEnum {

    MOK(0,"成功"),
    UNKNOWN(1,"未知错误"),
    INVALID_PARAM(2,"无效参数"),
    UNSUPPORTED(3,"引擎不支持"),
    NO_MEMORY(4,"内存不足"),
    BAD_STATE(5,"状态错误"),
    USER_CANCEL(6,"用户取消相关操作"),
    EXPIRED(7,"操作时间过期"),
    USER_PAUSE(8,"用户暂停操作"),
    BUFFER_OVERFLOW(9,"缓冲上溢"),
    BUFFER_UNDERFLOW(10,"缓冲下溢"),
    NO_DISKSPACE(11,"存贮空间不足"),
    COMPONENT_NOT_EXIST(12,"组件不存在"),
    GLOBAL_DATA_NOT_EXIST(13,"全局数据不存在"),
    NO_FACE_DETECTED(14,"未检出到人脸"),
    FACE_DOES_NOT_MATCH(15,"人脸不匹配"),
    DUPLICATE_SUBMIT(16,"主键冲突"),
    PARAM_ERROR(17,"参数错误"),
    GLOBE_ERROR(18,"系统异常"),
    DOWNLOAD_IMAGE_ERROR(19,"图片下载失败"),

    INVALID_APP_ID(28673,"无效的AppId"),
    INVALID_SDK_ID(28674,"无效的SdkKey"),
    INVALID_ID_PAIR(28675,"AppId和SdkKey不匹配");


    private Integer code;
    private String description;

    public static ErrorCodeEnum getDescriptionByCode(Integer code){
        for(ErrorCodeEnum errorCodeEnum : ErrorCodeEnum.values()){
            if(code.equals(errorCodeEnum.getCode())){
                return errorCodeEnum;
            }
        }
        return  ErrorCodeEnum.UNKNOWN;
    }

}
