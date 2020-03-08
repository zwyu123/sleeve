package com.lin.sleeve.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

public class JsonUtil {

    public static <T> List<T> jsonToList(String str) {
        if (str == null) {
            return null;
        }
        List<T> list = JSON.parseObject(str, new TypeReference<List<T>>(){});
        return list;
    }
}
