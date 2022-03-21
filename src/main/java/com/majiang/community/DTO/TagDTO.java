package com.majiang.community.DTO;

import lombok.Data;

import java.util.List;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName TagDTO.java
 * @Description TODO
 * @createTime 2022年03月21日 14:18:00
 */
@Data
public class TagDTO {
    private String categoryName;

    private List<String> tags;
}
