package com.rjhycl.community.model;

import lombok.Data;

/**
 * @ClassName User
 * @Description User对象模型
 * @Author RJH
 * @Date 2019/10/30 23:40
 * @Version 1.0
 **/
@Data
public class User {
    private Integer id;
    private String accountId;
    private String name;
    private String bio;
    private String avatarUrl;
    private String token;
    private long gmtCreate;
    private long gmtModified;

}
