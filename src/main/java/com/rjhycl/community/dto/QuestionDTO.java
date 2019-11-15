package com.rjhycl.community.dto;

import com.rjhycl.community.model.User;
import lombok.Data;

/**
 * @ClassName QuestionDTO
 * @Description TODO
 * @Author RJH
 * @Date 2019/11/10 15:03
 * @Version 1.0
 **/
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private long gmtCreate;
    private long gmtModified;
    private Integer createor;
    private Integer commentCount;//回复数
    private Integer viewCount;//浏览数
    private Integer likeCount;//点赞数
    private User user;
}
