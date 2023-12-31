package com.dh.gulimall.product.controller;

import com.dh.common.utils.R;
import com.dh.gulimall.product.entity.CategoryBrandRelationEntity;
import com.dh.gulimall.product.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


/**
 * 品牌分类关联
 *
 * @author denghui
 * @email dengh9098@gmail.com
 * @date 2023-06-14 15:54:21
 */
@RestController
@RequestMapping("product/categorybrandrelation")
public class CategoryBrandRelationController {
    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    /**
     * 列表
     */
//    @RequestMapping("/list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = categoryBrandRelationService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }

    @RequestMapping("/catelog/list")
    public R catelogList(@RequestParam("brandId") Long brandId){
//        PageUtils page = categoryBrandRelationService.queryPage();
//        CategoryBrandRelationEntity categoryBrandRelation = categoryBrandRelationService.getById(id);
        List<CategoryBrandRelationEntity> catelogs = categoryBrandRelationService.getCatelog(brandId);

        return R.ok().put("data", catelogs);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		CategoryBrandRelationEntity categoryBrandRelation = categoryBrandRelationService.getById(id);

        return R.ok().put("categoryBrandRelation", categoryBrandRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CategoryBrandRelationEntity categoryBrandRelation){
//		categoryBrandRelationService.save(categoryBrandRelation);
        categoryBrandRelationService.saveRelation(categoryBrandRelation);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CategoryBrandRelationEntity categoryBrandRelation){
		categoryBrandRelationService.updateById(categoryBrandRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		categoryBrandRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
