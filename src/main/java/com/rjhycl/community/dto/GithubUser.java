package com.rjhycl.community.dto;

import lombok.Data;

/**
 * @ClassName GithubUser
 * @Description GithubUserDTO
 * @Author RJH
 * @Date 2019/10/25 23:18
 * @Version 1.0
 **/
@Data
public class GithubUser {
    private long id;
    private String login;
    private String bio;
    private String avatarUrl;
}
