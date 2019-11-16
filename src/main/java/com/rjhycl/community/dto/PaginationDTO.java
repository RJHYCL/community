package com.rjhycl.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PaginationDTO
 * @Author RJH
 * @Date 2019/11/16 0:59
 * @Version 1.0
 **/
@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;//上一页
    private boolean showFirstPage;//首页
    private boolean showNextPage;//下一页
    private boolean showEndPage;//尾页
    private Integer page;//当前页
    private List<Integer> pages = new ArrayList<Integer>();//页面展示页码集合
    private Integer totalPage;//总分页数

    public void setPagination(Integer totalCount, Integer page, Integer size) {

        if(totalCount % size == 0){
            totalPage = totalCount / size;
        }else {
            totalPage = totalCount / size + 1;
        }
        if(page < 1){
            page = 1;
        }
        if(page > totalPage){
            page = totalPage;
        }

        this.page = page;
        pages.add(page);
        for(int i=1;i<=3;i++){
            if(page - i > 0){
                pages.add(0,page - i);
            }
            if(page + i <= totalPage){
                pages.add(page + i);
            }
        }
        //是否展示上一页
        if(page == 1){
            showPrevious = false;
        }else {
            showPrevious = true;
        }
        //是否展示下一页
        if(page == totalPage){
            showNextPage = false;
        }else {
            showNextPage = true;
        }
        //是否展示首页
        if(pages.contains(1)){
            showFirstPage = false;
        }else {
            showFirstPage = true;
        }
        //是否展示尾页
        if(pages.contains(totalPage)){
            showEndPage = false;
        }else {
            showEndPage = true;
        }




    }
}
