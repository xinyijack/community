package com.majiang.community.Cache;

import com.majiang.community.DTO.TagDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName TagCache.java
 * @Description TODO
 * @createTime 2022年03月21日 14:18:00
 */
public class TagCache {
    public static List<TagDTO> getTags() {
        List<TagDTO> tagDTOS = new ArrayList<>();
        TagDTO program = new TagDTO();
        program.setCategoryName("开发语言");
        program.setTags(Arrays.asList("javascript","php","CSS","Html","Java","C++","Ruby","Node.js","Swift","Python","C#","GO","perl","Node","Erlang"));
        tagDTOS.add(program);

        TagDTO framwork = new TagDTO();
        framwork.setCategoryName("平台框架");
        framwork.setTags(Arrays.asList("Spring","Spring Boot","Spring MVC","flusk","ruby-on-rails","tornado","yii"));
        tagDTOS.add(framwork);

        TagDTO server = new TagDTO();
        server.setCategoryName("服务器");
        server.setTags(Arrays.asList("Linux","Unix","Mac OS","Windows","Centos"));
        tagDTOS.add(server);

        TagDTO db = new TagDTO();
        db.setCategoryName("数据库");
        db.setTags(Arrays.asList("Mysql","Redis","mongodb","sql","sql server","postgresql","sqlite","oracle"));
        tagDTOS.add(db);

        TagDTO tool = new TagDTO();
        tool.setCategoryName("开发工具");
        tool.setTags(Arrays.asList("Git","github","visual-studio-code","vim","sublime-text"));
        tagDTOS.add(tool);

        return tagDTOS;
    }

    public static String filterInvalid(String tags) {
        String[] split = StringUtils.split(tags, ",");
        List<TagDTO> tagDTOS = getTags();

        List<String> tagList = tagDTOS.stream().flatMap(tag -> tag.getTags().stream()).collect(Collectors.toList());
        String invalid = Arrays.stream(split).filter(t -> StringUtils.isBlank(t) || !tagList.contains(t)).collect(Collectors.joining(","));

        return invalid;
    }
}