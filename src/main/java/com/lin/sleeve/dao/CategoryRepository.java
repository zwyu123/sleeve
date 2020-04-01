package com.lin.sleeve.dao;

import com.lin.sleeve.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByIsRootOrderByIndexAsc(Boolean isRoot);
}
