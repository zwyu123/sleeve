package com.lin.sleeve.vo;

import com.lin.sleeve.entity.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
public class CategoriesVo {
    private List<CategoryVo> roots;
    private List<CategoryVo> subs;

    public CategoriesVo(Map<Integer, List<Category>> map) {
        this.roots = map.get(1).stream()
                .map(CategoriesVo.CategoryVo::new)
                .collect(Collectors.toList());
        this.subs = map.get(2).stream()
                .map(CategoriesVo.CategoryVo::new)
                .collect(Collectors.toList());
    }

    @Getter
    @Setter
    class CategoryVo {
        private Long id;
        private String name;
        private Boolean isRoot;
        private String img;
        private Long parentId;
        private Long index;

        public CategoryVo(Category category) {
            BeanUtils.copyProperties(category, this);
        }
    }
}
