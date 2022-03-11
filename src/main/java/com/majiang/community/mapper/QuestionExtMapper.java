package com.majiang.community.mapper;

import com.majiang.community.model.Question;

public interface QuestionExtMapper {
    int incView(Question record);

    int incCommentCount(Question record);
}