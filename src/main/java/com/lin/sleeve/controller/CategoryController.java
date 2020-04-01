package com.lin.sleeve.controller;

import com.lin.sleeve.entity.Category;
import com.lin.sleeve.service.CategoryService;
import com.lin.sleeve.vo.CategoriesVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public CategoriesVo getAll() {
        Map<Integer, List<Category>> categories = categoryService.getAll();
        CategoriesVo categoriesVo = new CategoriesVo(categories);
        return categoriesVo;
    }
}
