package com.lin.sleeve.service;

import com.lin.sleeve.dao.CategoryRepository;
import com.lin.sleeve.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Map getAll() {
        List<Category> roots = categoryRepository.findAllByIsRootOrderByIndexAsc(true);
        List<Category> subs = categoryRepository.findAllByIsRootOrderByIndexAsc(false);
        Map<Integer, List<Category>> categories = new HashMap<>();
        // 第一级目录
        categories.put(1, roots);
        // 第二级目录
        categories.put(2, subs);
        return categories;
    }
}
