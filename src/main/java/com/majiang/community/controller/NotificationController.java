package com.majiang.community.controller;

import com.majiang.community.DTO.NotificationDTO;
import com.majiang.community.DTO.PaginationDTO;
import com.majiang.community.enums.NotificationTypeEnum;
import com.majiang.community.model.Notification;
import com.majiang.community.model.User;
import com.majiang.community.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName NotificationController.java
 * @Description TODO
 * @createTime 2022年03月24日 18:49:00
 */
@Controller
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping(value = "/notification/{id}")
    public String profile(HttpServletRequest request,
                          @PathVariable(name = "id") Long id) {
        User user = (User) request.getSession().getAttribute("user");

        if (user == null) return "redirect:/";

        NotificationDTO notificationDTO = notificationService.read(id, user);

        if (NotificationTypeEnum.REPLY_COMMENT.getType() == notificationDTO.getType() || NotificationTypeEnum.REPLY_QUESTION.getType() == notificationDTO.getType()) {
            return "redirect:/question/" + notificationDTO.getOuterid();
        } else {
            return "redirect:/";
        }
}
}
