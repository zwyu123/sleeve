package com.lin.sleeve.entity;

import com.lin.sleeve.util.JsonUtil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Setter
public class Sku extends BaseEntity {
    @Id
    private Long id;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private Boolean online;
    private String img;
    private String title;
    private Long spuId;
    private Long categoryId;
    private Long rootCategoryId;

    private String specs;
    private String code;
    private Long stock;

    public List<Spec> getSpecs() {
        if (specs == null) {
            return Collections.emptyList();
        }
        return JsonUtil.jsonToList(specs);
    }
}
