package com.majiang.community.DTO;

import com.majiang.community.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName QuestionDTO.java
 * @Description TODO
 * @createTime 2022年02月23日 09:29:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {
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
    private User user;
}
