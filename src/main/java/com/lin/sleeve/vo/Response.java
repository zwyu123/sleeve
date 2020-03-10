package com.lin.sleeve.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.lin.sleeve.constant.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JSONType(orders = {"result", "message"})
public class Response {
    private Result result;
    private String message;
}
