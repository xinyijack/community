package com.majiang.community.controller;

import com.majiang.community.Cache.TagCache;
import com.majiang.community.DTO.QuestionDTO;
import com.majiang.community.model.Question;
import com.majiang.community.model.User;
import com.majiang.community.service.QuestionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName PublishController.java
 * @Description TODO
 * @createTime 2022年02月21日 10:36:00
 */
@Controller
public class PublishController {

    @Autowired
    QuestionService questionService;

    @GetMapping(value = "/publish/{id}")
    public String edit(@PathVariable(name = "id") Long id, Model model) {
        QuestionDTO question = questionService.getById(id);
        model.addAttribute("title", question.getTitle());
        model.addAttribute("description", question.getDescription());
        model.addAttribute("tag", question.getTag());
        model.addAttribute("id", question.getId());

        model.addAttribute("tags", TagCache.getTags());
        return "publish";
    }

    @GetMapping("/publish")
    public String publish(Model model) {
        model.addAttribute("tags", TagCache.getTags());
        return "publish";
    }

    @PostMapping(value = "/publish")
    public String doPublish(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "tag", required = false) String tag,
            @RequestParam(value = "id", required = false) Long id,
            HttpServletRequest request,
            Model model) {
        model.addAttribute("title", title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);
        model.addAttribute("tags", TagCache.getTags());

        if (title == null || title == "") {
            model.addAttribute("error", "标题不能为空");
            return "publish";
        }
        if (description == null || description == "") {
            model.addAttribute("error", "问题补充不能为空");
            return "publish";
        }
        if (tag == null || tag == "") {
            model.addAttribute("error", "标签不能为空");
            return "publish";
        }

        String invalid = TagCache.filterInvalid(tag);
        if (StringUtils.isNotBlank(invalid)) {
            model.addAttribute("error", "输入非法标签" + invalid);
            return "publish";
        }

        User user = (User) request.getSession().getAttribute("user");

        if (user == null) {
            model.addAttribute("error", "用户未登陆");
            return "publish";
        }
        Question question = new Question();
        question.setTag(tag);
        question.setDescription(description);
        question.setTitle(title);
        question.setCreator(user.getId());
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());
        question.setId(id);

        questionService.createOrUpdate(question);
        return "redirect:/";
    }
}
