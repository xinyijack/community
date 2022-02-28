package com.majiang.community.service;

import com.majiang.community.DTO.PaginationDTO;
import com.majiang.community.DTO.QuestionDTO;
import com.majiang.community.mapper.QuestionMapper;
import com.majiang.community.mapper.UserMapper;
import com.majiang.community.model.Question;
import com.majiang.community.model.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName QuestionService.java
 * @Description TODO
 * @createTime 2022年02月23日 09:32:00
 */
@Service
public class QuestionService {

    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    UserMapper userMapper;

    public PaginationDTO list(Integer page, Integer size) {
        Integer totalPage;
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.count();
        //计算总页数totalPage
        totalPage = getToltalPage(size, totalCount);

        if (page < 1) page = 1;
        if (page > totalPage) page = totalPage;

        paginationDTO.setPagination(totalPage, page);

        //计算总页码数
        Integer offset = (page - 1) * size;
        List<Question> questionList = questionMapper.list(offset, size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();


        for (Question question : questionList) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }

    @NotNull
    private Integer getToltalPage(Integer size, Integer totalCount) {
        Integer totalPage;
        Integer quotient = totalCount / size;
        Integer residue = totalCount % size;
        if (residue == 0) totalPage = quotient;
        else totalPage = quotient + 1;
        return totalPage;
    }

    public PaginationDTO list(Integer userId, Integer page, Integer size) {
        Integer totalPage;
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.countByUserId(userId);
        totalPage = getToltalPage(size, totalCount);

        if (page < 1) page = 1;
        if (page > totalPage && totalPage != 0) page = totalPage;

        paginationDTO.setPagination(totalPage, page);
        //计算总页码数


        Integer offset = (page - 1) * size;
        List<Question> questionList = questionMapper.listByUserId(userId, offset, size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();


        for (Question question : questionList) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }
}
