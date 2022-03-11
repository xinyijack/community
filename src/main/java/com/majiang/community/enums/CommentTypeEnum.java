package com.majiang.community.enums;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName CommentTypeEnum.java
 * @Description TODO
 * @createTime 2022年03月10日 10:13:00
 */
public enum CommentTypeEnum {
    QUESTION(1),
    COMMENT(2);

    private Integer type;

    CommentTypeEnum(Integer type) {
        this.type = type;
    }

    public static boolean isExist(Integer type) {
        for (CommentTypeEnum commentTypeEnum : CommentTypeEnum.values()) {
            if (commentTypeEnum.getType() == type) {
                return true;
            }
        }
        return false;
    }

    public Integer getType() {
        return type;
    }
}
