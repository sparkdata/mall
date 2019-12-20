package com.mall.common.response;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.client.naming.utils.CollectionUtils;
import com.mall.common.constant.WordConstant;
import org.springframework.validation.ObjectError;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.List;

/**
 * PROJECT: gateway
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2018/12/11
 */
public class GenericResponse<T> implements Serializable {

    private static final long serialVersionUID = -8600893080428359242L;

    public static final GenericResponse SUCCESS = new GenericResponse("1000", WordConstant.SUCCESS);
    public static final GenericResponse FAIL = new GenericResponse("1001", WordConstant.FAIL);
    public static final GenericResponse ERROR_PARAM = new GenericResponse("1002", WordConstant.ERROR_PARAM);
    public static final GenericResponse SYSTEM_ERROR = new GenericResponse("1003", WordConstant.SYSTEM_ERROR);
    public static final GenericResponse REQUEST_ILLEGAL = new GenericResponse("1004", WordConstant.REQUEST_ILLEGAL);


    /**
     * 状态码
     */
    private String code;
    /**
     * 状态信息
     */
    private String message;
    /**
     * 对应body
     */
    private T body;

    public GenericResponse() {
    }

    public GenericResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public GenericResponse(String code, String message, T body) {
        this.code = code;
        this.message = message;
        this.body = body;
    }

    public GenericResponse(T body) {
        this.code = SUCCESS.getCode();
        this.message = SUCCESS.getMessage();
        this.body = body;
    }

    public GenericResponse(IExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.message = exceptionEnum.getMessage();
    }

    public GenericResponse(IExceptionEnum exceptionEnum, List<ObjectError> list) {
        this.code = exceptionEnum.getCode();
        if (CollectionUtils.isEmpty(list)) {
            this.message = exceptionEnum.getMessage();
            return;
        }
        this.message = MessageFormat.format(this.getMessage(), list.get(0).getDefaultMessage());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}