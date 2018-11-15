package com.itmuch.cloud.study.commodity.exception;


import com.itmuch.cloud.study.common.base.Result;
import com.itmuch.cloud.study.common.base.Results;
import com.itmuch.cloud.study.common.enums.ErrorCodeEnum;
import com.itmuch.cloud.study.common.exception.RRException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 * 
 * @author xierongli
 * @email sunlightcs@gmail.com
 * @date 2016年10月27日 下午10:16:19
 */
@RestControllerAdvice
@Slf4j
public class RRExceptionHandler {

	/**
	 * 自定义异常
	 */
	@ExceptionHandler(RRException.class)
	public Result handleRRException(RRException e){
		log.warn("errorCode："+e.getCode()+" errorMsg: "+e.getMessage());
		return Results.newFailedResult(e.getCode(),e.getMessage());
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public Result handleDuplicateKeyException(DuplicateKeyException e){
		log.error(e.getMessage(), e);
		return Results.newFailedResult(ErrorCodeEnum.DUPLICATE_SUBMIT.getCode(),e.getMessage());
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public Result handleIllegalArgumentException(IllegalArgumentException e){
		log.error(e.getMessage(), e);
		return Results.newFailedResult(ErrorCodeEnum.PARAM_ERROR.getCode(),e.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public Result handleException(Exception e){
		log.error(e.getMessage(), e);
		return Results.newFailedResult(ErrorCodeEnum.GLOBE_ERROR.getCode(),ErrorCodeEnum.GLOBE_ERROR.getDescription());
	}



}
