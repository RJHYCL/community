package com.rjhycl.community.service;

import com.rjhycl.community.dto.PaginationDTO;
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


    public PaginationDTO list(Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.count();
        paginationDTO.setPagination(totalCount,page,size);
        if(page < 1){
            page = 1;
        }
        if(page > paginationDTO.getTotalPage()){
            page = paginationDTO.getTotalPage();
        }

        Integer offset = size * (page - 1);
        List<Question> questionList = questionMapper.list(offset,size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();

        for (Question question : questionList) {
             User user = userMapper.selectById(question.getCreateor());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }

        paginationDTO.setQuestions(questionDTOList);

        return paginationDTO;
    }
}
