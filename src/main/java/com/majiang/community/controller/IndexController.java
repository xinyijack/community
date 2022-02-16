package com.majiang.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName IndexController.java
 * @Description 首页controller
 * @createTime 2022年02月16日 09:42:00
 */
@Controller
public class IndexController {
    @GetMapping(value = "/")
    public String index() {
        return  "index";
    }
}
