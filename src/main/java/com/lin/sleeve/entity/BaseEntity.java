package com.lin.sleeve.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @JSONField(serialize = false)
    private Date createTime;
    @JSONField(serialize = false)
    private Date updateTime;
    @JSONField(serialize = false)
    private Date deleteTime;
}
