package com.majiang.community.exception;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName CustomizeException.java
 * @Description TODO
 * @createTime 2022年03月07日 10:49:00
 */
public class CustomizeException extends RuntimeException {

    private String message;
    private Integer code;

    public CustomizeException (ICustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
        this.code = errorCode.getCode();
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
