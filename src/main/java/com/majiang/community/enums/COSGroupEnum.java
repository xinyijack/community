package com.majiang.community.enums;

/**
 * @author jack_xin
 * @ClassName COSGroupEnum
 * @Desc TODO
 * @date 2022年04月03日 15:13
 * @Version TODO
 */
public enum COSGroupEnum {
    COMMUNITY(1, "community"),;
    private Integer code;
    private String name;

    COSGroupEnum(Integer code, String name) {
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
