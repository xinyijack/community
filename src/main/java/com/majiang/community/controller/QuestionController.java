package com.majiang.community.controller;

import com.majiang.community.DTO.QuestionDTO;
import com.majiang.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName QuestionController.java
 * @Description TODO
 * @createTime 2022年03月01日 12:19:00
 */
@Controller
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(value = "id") Long id, Model model) {
        QuestionDTO questionDTO = questionService.getById(id);
        //增加累加阅读数
        questionService.incView(id);
        model.addAttribute("question", questionDTO);
        return "question";
    }
}
