package com.rjhycl.community.service;

import com.rjhycl.community.dto.QuestionDTO;
import com.rjhycl.community.mapper.QuestionMapper;
import com.rjhycl.community.mapper.UserMapper;
import com.rjhycl.community.model.Question;
import com.rjhycl.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName QuestionService
 * @Description TODO
 * @Author RJH
 * @Date 2019/11/10 15:11
 * @Version 1.0
 **/
@Service
public class QuestionService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;


    public List<QuestionDTO> list() {
        List<Question> questionList = questionMapper.list();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questionList) {
             User user = userMapper.selectById(question.getCreateor());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
