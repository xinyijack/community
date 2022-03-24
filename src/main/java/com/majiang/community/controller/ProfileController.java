package com.majiang.community.controller;

import com.majiang.community.DTO.PaginationDTO;
import com.majiang.community.mapper.UserMapper;
import com.majiang.community.model.User;
import com.majiang.community.service.NotificationService;
import com.majiang.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName ProfileController.java
 * @Description TODO
 * @createTime 2022年02月27日 18:11:00
 */
@Controller
public class ProfileController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    QuestionService questionService;

    @Autowired
    private NotificationService notificationService;

    @GetMapping(value = "/profile/{action}")
    public String profile(HttpServletRequest request,
                          @PathVariable(name = "action") String action,
                          @RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "size", defaultValue = "5")Integer size,
                          Model model) {

        User user = (User) request.getSession().getAttribute("user");

        if (user == null) return "redirect:/";
        if ("questions".equals(action)) {
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "我的提问");
            PaginationDTO paginationDTO = questionService.list(user.getId(), page, size);
            model.addAttribute("paginationDTO", paginationDTO);
        }
        else if("replies".equals(action)) {
            PaginationDTO paginationDTO = notificationService.list(user.getId(), page, size);
            Long unreadCount = notificationService.unreadCount(user.getId());
            model.addAttribute("paginationDTO", paginationDTO);
            model.addAttribute("section", "replies");
            model.addAttribute("unreadCount", unreadCount);
            model.addAttribute("sectionName", "最新回复");
        }
        return "profile";
    }
}
