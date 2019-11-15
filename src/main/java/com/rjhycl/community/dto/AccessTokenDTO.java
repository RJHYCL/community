package com.rjhycl.community.dto;


import lombok.Data;

/**
 * @ClassName GithubProvider
 * @Description 发送post请求获取access token
 * @Author RJH
 * @Date 2019/10/24 23:37
 * @Version 1.0
 **/
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
