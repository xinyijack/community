package com.majiang.community.mapper;

import com.majiang.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName QuestionMapper.java
 * @Description TODO
 * @createTime 2022年02月21日 16:33:00
 */
@Mapper
public interface QuestionMapper {
    @Insert("insert into question(title, description, gmt_create, gmt_modified, creator, comment_count, view_count, like_count, tag) values (#{title}, #{description}, #{gmtCreate}, #{gmtModified}, #{creator}, #{commentCount}, #{viewCount}, #{likeCount}, #{tag})")
    public void create(Question question);
}
