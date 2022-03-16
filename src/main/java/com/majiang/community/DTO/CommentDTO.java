package com.majiang.community.DTO;

import com.majiang.community.model.User;
import lombok.Data;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName CommentDTO.java
 * @Description TODO
 * @createTime 2022年03月14日 11:46:00
 */
@Data
public class CommentDTO {
    private Long id;

    private Long parentId;

    private Integer type;

    private Long commentator;

    private Long gmtCreate;

    private Long gmtModified;

    private Long likeCount;

    private String content;

    private User user;
}
