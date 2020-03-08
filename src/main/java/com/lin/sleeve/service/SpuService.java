package com.lin.sleeve.service;

import com.lin.sleeve.dao.SpuRepository;
import com.lin.sleeve.entity.Spu;
import com.lin.sleeve.vo.Paging;
import com.lin.sleeve.vo.SpuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpuService {
    @Autowired
    private SpuRepository spuRepository;

    public Spu getSpu(Long id) {
        return spuRepository.findOneById(id);
    }

    /**
     * 分页查询Spu详情
     * @param pageNum 第几页（从0开始 -> 第1页）
     * @param pageSize 每页的容量
     * @return
     */
    public Paging<SpuVo> getSpuList(Integer pageNum, Integer pageSize) {
        Pageable page = PageRequest.of(pageNum, pageSize, Sort.by("createTime").descending());
        Page<Spu> spuPage = spuRepository.findAll(page);
        List<Spu> spuList = spuPage.getContent();

        List<SpuVo> spuVoList = spuList.stream().map(t ->
                SpuVo.builder().id(t.getId())
                        .title(t.getTitle())
                        .subtitle(t.getSubtitle())
                        .img(t.getImg())
                        .forThemeImg(t.getForThemeImg())
                        .price(t.getPrice())
                        .discountPrice(t.getDiscountPrice())
                        .description(t.getDescription())
                        .tags(t.getTags())
                        .sketchSpecId(t.getSketchSpecId())
                        .build())
                .collect(Collectors.toList());
        Paging paging = new Paging(spuPage);
        paging.setItems(spuVoList);

        return paging;
    }
}
