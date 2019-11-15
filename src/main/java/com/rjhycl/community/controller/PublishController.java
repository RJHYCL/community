package com.rjhycl.community.controller;

import com.rjhycl.community.mapper.QuestionMapper;
import com.rjhycl.community.mapper.UserMapper;
import com.rjhycl.community.model.Question;
import com.rjhycl.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName PublishController
 * @Description Publish
 * @Author RJH
 * @Date 2019/11/7 0:49
 * @Version 1.0
 **/
@Controller
public class PublishController {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }
    @PostMapping("/publish")
    public String addQuestion(@RequestParam(name="title")String title,
                              @RequestParam(name="description")String description,
                              @RequestParam(name="tag")String tag,
                              HttpServletRequest request,
                              Model model){
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);
        if(title == null || title == ""){
            model.addAttribute("error","问题标题不能为空");
            return "publish";
        }
        if(description == null || description == ""){
            model.addAttribute("error","问题内容不能为空");
            return "publish";
        }
        if(tag == null || tag == ""){
            model.addAttribute("error","标签不能为空");
            return "publish";
        }

        User user = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length != 0){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    user = userMapper.selectByToken(token);
                    if (user != null) {
                        request.setAttribute("user",user);

                        Question question = new Question();
                        question.setTitle(title);
                        question.setDescription(description);
                        question.setTag(tag);
                        question.setCreateor(user.getId());
                        question.setGmtCreate(System.currentTimeMillis());
                        question.setGmtModified(question.getGmtCreate());
                        questionMapper.insertQuestion(question);
                    }
                    break;
                }
            }
        }
        if(user == null){
            model.addAttribute("error","用户未登录");
            return "publish";
        }

        return "redirect:/";
    }
}
