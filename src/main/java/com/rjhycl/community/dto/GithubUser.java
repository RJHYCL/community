package com.rjhycl.community.dto;

/**
 * @ClassName GithubUser
 * @Description GithubUserDTO
 * @Author RJH
 * @Date 2019/10/25 23:18
 * @Version 1.0
 **/
public class GithubUser {
    private long id;
    private String login;
    private String bio;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "GithubUser{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", bio=" + bio +
                '}';
    }
}
