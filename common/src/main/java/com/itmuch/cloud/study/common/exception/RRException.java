package com.itmuch.cloud.study.common.exception;


import com.itmuch.cloud.study.common.enums.ErrorCodeEnum;

/**
 * 自定义异常
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月27日 下午10:11:27
 */
public class RRException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;

    public RRException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public RRException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public RRException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public RRException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public RRException(ErrorCodeEnum errorCodeEnum, Throwable e) {
        super(errorCodeEnum.getDescription(), e);
        this.msg = errorCodeEnum.getDescription();
        this.code = errorCodeEnum.getCode();
    }

    public RRException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getDescription());
        this.msg = errorCodeEnum.getDescription();
        this.code = errorCodeEnum.getCode();
    }




    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


}
