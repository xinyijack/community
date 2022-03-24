package com.majiang.community.enums;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName NotificationStatusEnum.java
 * @Description TODO
 * @createTime 2022年03月24日 11:39:00
 */
public enum NotificationStatusEnum {
    UNREAD(0),
    READ(1);
    private int status;

    public int getStatus() {
        return status;
    }

    NotificationStatusEnum(int status) {
        this.status = status;
    }
}
