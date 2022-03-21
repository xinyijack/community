package com.majiang.community.Cache;

import com.majiang.community.DTO.TagDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName TagCache.java
 * @Description TODO
 * @createTime 2022年03月21日 14:18:00
 */
public class TagCache {
    public static List<TagDTO> getTags() {
        ArrayList<TagDTO> tagDTOS = new ArrayList<>();
        TagDTO program = new TagDTO();
        program.setCategoryName("开发语言");
        program.setTags(Arrays.asList("js","php","css","html","python","java","C++","ruby","node.js","swift"));
        tagDTOS.add(program);

        TagDTO framwork = new TagDTO();
        framwork.setCategoryName("平台框架");
        framwork.setTags(Arrays.asList("Spring","Spring Boot","Spring MVC","flusk","ruby-on-rails","tornado","yii"));
        tagDTOS.add(framwork);

        TagDTO server = new TagDTO();
        server.setCategoryName("服务器");
        server.setTags(Arrays.asList("Linux","Unix","Mac OS","Windows","Centos"));
        tagDTOS.add(server);

        return tagDTOS;
    }
}
