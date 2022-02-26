package com.majiang.community.service;

import com.majiang.community.DTO.PaginationDTO;
import com.majiang.community.DTO.QuestionDTO;
import com.majiang.community.mapper.QuestionMapper;
import com.majiang.community.mapper.UserMapper;
import com.majiang.community.model.Question;
import com.majiang.community.model.User;
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
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.count();

        paginationDTO.setPagination(totalCount, page, size);

        if (page < 1) page = 1;
        if (page > paginationDTO.getTotalPage()) page = paginationDTO.getTotalPage();

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
}
