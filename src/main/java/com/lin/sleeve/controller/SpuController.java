package com.lin.sleeve.controller;

import com.lin.sleeve.service.SpuService;
import com.lin.sleeve.vo.Paging;
import com.lin.sleeve.vo.SpuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spu")
public class SpuController {
    @Autowired
    private SpuService spuService;

    @GetMapping("/list")
    public Paging<SpuVo> getSpuList(@RequestParam(defaultValue = "0") Integer start,
                                    @RequestParam(defaultValue = "10") Integer count) {
        int pageNum = start / count;
        return spuService.getSpuList(pageNum, count);
    }
}
