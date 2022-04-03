package com.majiang.community.enums;

/**
 * @author jack_xin
 * @ClassName SeparatorEnum
 * @Desc TODO
 * @date 2022年04月03日 15:21
 * @Version TODO
 */
public enum SeparatorEnum {
    WINDOWS(1, "\\"),
    LINUX(2, "/");

    private Integer code;
    private String name;

    SeparatorEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
