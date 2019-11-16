package com.rjhycl.community.mapper;

import com.rjhycl.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QuestionMapper {
    @Insert("insert into question (title,description,tag,gmt_create,gmt_modified,createor,comment_count,view_count,like_count) " +
            "values (#{title},#{description},#{tag},#{gmtCreate},#{gmtModified},#{createor},#{commentCount},#{viewCount},#{likeCount})")
    void insertQuestion(Question question);
    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(@Param("offset")Integer offset,@Param("size") Integer size);

    @Select("select count(1) from question")
    Integer count();

}
