package com.majiang.community.DTO;

import lombok.Data;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName CommentDTO.java
 * @Description TODO
 * @createTime 2022年03月09日 09:35:00
 */
@Data
public class CommentDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
