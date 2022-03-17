package com.majiang.community.controller;

import com.majiang.community.DTO.CommentCreateDTO;
import com.majiang.community.DTO.ResultDTO;
import com.majiang.community.exception.CustomizeErrorCode;
import com.majiang.community.mapper.CommentMapper;
import com.majiang.community.model.Comment;
import com.majiang.community.model.User;
import com.majiang.community.service.CommentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName CommentController.java
 * @Description TODO
 * @createTime 2022年03月09日 09:30:00
 */
@Controller
public class CommentController {

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/comment")
    public Object post(@RequestBody CommentCreateDTO commentCreateDTO, HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        if (user == null) {
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }
        if (null == commentCreateDTO || StringUtils.isBlank(commentCreateDTO.getContent())) {
            return ResultDTO.errorOf(CustomizeErrorCode.CONTENT_IS_EMPTY);
        }
        Comment comment = new Comment();
        comment.setParentId(commentCreateDTO.getParentId());
        comment.setContent(commentCreateDTO.getContent());
        comment.setCommentator(1L);
        comment.setLikeCount(0L);
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setType(commentCreateDTO.getType());
        commentService.insert(comment);
        return ResultDTO.okOf();
    }
}
