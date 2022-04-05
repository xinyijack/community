package com.majiang.community.DTO;

import lombok.Data;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName QuestionQueryDTO.java
 * @Description TODO
 * @createTime 2022年04月05日 13:05:00
 */
@Data
public class QuestionQueryDTO {
    private String search;
    private Integer page;
    private Integer size;
}
