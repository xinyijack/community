package com.majiang.community.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 * @version 1.0.0
 * @ClassName PageDTO.java
 * @Description TODO
 * @createTime 2022年02月24日 10:32:00
 */
@Data
public class PaginationDTO<T> {
    private List<T> data;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;

    public void setPagination(Integer totalPage, Integer page) {
        this.page = page;
        this.totalPage = totalPage;
        pages.add(page);
        for (int i = 1; i <=3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }

        //是否展示上一页
        if (page == 1) {
            showPrevious = false;
        }
        else {
            showPrevious = true;
        }
        //是否展示下一页
        if (page == totalPage) {
            showNext = false;
        }
        else {
            showNext = true;
        }

        //是否展示首页
        if (pages.contains(1)) {
            showFirstPage = false;
        }
        else {
            showFirstPage = true;
        }

        //是否展示尾页
        if (pages.contains(totalPage)) {
            showEndPage = false;
        }
        else {
            showEndPage = true;
        }
    }
}
