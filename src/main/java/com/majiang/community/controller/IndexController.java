package com.majiang.community.controller;

import com.majiang.community.mapper.UserMapper;
import com.majiang.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping(value = "/")
    public String index(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null)
                        request.getSession().setAttribute("user", user);
                    break;
                }
            }
        }

        return  "index";
    }
}
