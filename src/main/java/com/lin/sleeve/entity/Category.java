package com.lin.sleeve.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Category extends BaseEntity {
    @Id
    private Long id;
    private String name;
    private String description;
    private Boolean isRoot;
    private String img;
    private Long parentId;
    private Long index;
}
