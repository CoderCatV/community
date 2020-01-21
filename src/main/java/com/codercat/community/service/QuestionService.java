package com.codercat.community.service;

import com.codercat.community.dto.QuestionDTO;
import com.codercat.community.model.Question;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: TODO
 * @author: zhoushaonan
 * @Date:2020/1/21
 * @Version 1.0
 */
public interface QuestionService {

    List<QuestionDTO> list();
}
