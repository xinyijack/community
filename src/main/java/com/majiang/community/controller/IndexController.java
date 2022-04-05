package com.majiang.community.controller;

import com.majiang.community.DTO.PaginationDTO;
import com.majiang.community.DTO.QuestionDTO;
import com.majiang.community.mapper.UserMapper;
import com.majiang.community.model.User;
import com.majiang.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName IndexController.java
 * @Description 首页controller
 * @createTime 2022年02月16日 09:42:00
 */
@Controller
public class IndexController {
    @Autowired
    UserMapper userMapper;

    @Autowired
    QuestionService questionService;

    @GetMapping(value = "/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5") Integer size,
                        @RequestParam(name = "search", required = false) String search ) {

        PaginationDTO<QuestionDTO> paginationDTO = questionService.list(search, page, size);
        model.addAttribute("paginationDTO", paginationDTO);
        model.addAttribute("search", search);
        return  "index";
    }
}
