package com.majiang.community.exception;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName CustomizeErrorCode.java
 * @Description TODO
 * @createTime 2022年03月07日 11:10:00
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND(2001, "查找的问题不在了，要不要换个试试？"),
    TARGET_PARAM_NOT_FOUND(2002, "未选中任何问题或评论进行回复"),
    NO_LOGIN(2003, "未登录请先登陆后重试"),
    SYS_ERROR(2004, "服务失恋了,请稍后再试！！！"),
    TYPE_PARAM_WRONG_(2005, "评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2006, "查找的评论不在了，要不要换个试试？");

    private Integer code;
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

}
