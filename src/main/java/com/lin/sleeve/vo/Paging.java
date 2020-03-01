package com.lin.sleeve.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Paging<T> {
    // 元素总数
    private Long total;
    // 起始页
    private Integer pageNum;
    // 每页的容量
    private Integer pageSize;
    // 返回分页总数
    private Integer totalPages;

    private List<T> items;

    public Paging(Page page) {
        this.total = page.getTotalElements();
        this.pageNum = page.getNumber();
        this.pageSize = page.getSize();
        this.totalPages = page.getTotalPages();
    }
}
