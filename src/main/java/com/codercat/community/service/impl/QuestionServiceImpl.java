package com.codercat.community.service.impl;

import com.codercat.community.dto.QuestionDTO;
import com.codercat.community.mapper.QuestionMapper;
import com.codercat.community.mapper.UserMapper;
import com.codercat.community.model.Question;
import com.codercat.community.model.User;
import com.codercat.community.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @author: zhoushaonan
 * @Date:2020/1/21
 * @Version 1.0
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Resource
    private QuestionMapper questionMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public List<QuestionDTO> list() {
        List<Question> questionList = questionMapper.list();
        List<QuestionDTO> questionDTOList = new ArrayList<QuestionDTO>();
        if (questionList != null && !questionList.isEmpty()) {
            for (Question question : questionList) {
                User user = userMapper.findUserById(question.getCreator());
                QuestionDTO questionDTO = new QuestionDTO();
                BeanUtils.copyProperties(question, questionDTO);
                questionDTO.setUser(user);
                questionDTOList.add(questionDTO);
            }

        }
        return questionDTOList;
    }
}
