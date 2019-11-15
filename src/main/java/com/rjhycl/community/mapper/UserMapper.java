package com.rjhycl.community.mapper;

import com.rjhycl.community.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    @Insert("insert into user (account_id,name,bio,avatar_url,token,gmt_create,gmt_modified) values (#{accountId},#{name},#{bio},#{avatarUrl},#{token},#{gmtCreate},#{gmtModified})")
    void insertUser(User user);
    @Select("select * from user where token = #{token}")
    User selectByToken(@Param("token") String token);
    @Select("select * from user where id = #{id}")
    User selectById(@Param("id") Integer id);
}
