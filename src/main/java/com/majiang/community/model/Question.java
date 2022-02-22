package com.majiang.community.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName Question.java
 * @Description TODO
 * @createTime 2022年02月22日 11:03:00
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Question {

    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
}
