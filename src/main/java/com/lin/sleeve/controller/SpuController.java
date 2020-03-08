package com.lin.sleeve.controller;

import com.lin.sleeve.entity.Spu;
import com.lin.sleeve.service.SpuService;
import com.lin.sleeve.vo.Paging;
import com.lin.sleeve.vo.SpuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spu")
public class SpuController {
    @Autowired
    private SpuService spuService;

    @GetMapping("/id/{id}/detail")
    public Spu getDetail(@PathVariable Long id) {
        Spu spu = spuService.getSpu(id);
        return spu;
    }

    @GetMapping("/list")
    public Paging<SpuVo> getSpuList(@RequestParam(defaultValue = "0") Integer start,
                                    @RequestParam(defaultValue = "10") Integer count) {
        int pageNum = start / count;
        return spuService.getSpuList(pageNum, count);
    }
}
