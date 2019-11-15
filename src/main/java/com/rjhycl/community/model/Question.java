package com.rjhycl.community.model;

import lombok.Data;

/**
 * @ClassName Question
 * @Description TODO
 * @Author RJH
 * @Date 2019/11/9 0:38
 * @Version 1.0
 **/
@Data
public class Question {
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
}
