package com.syzechuan.controller.admin;

import com.syzechuan.dto.CategoryDTO;
import com.syzechuan.dto.CategoryPageQueryDTO;
import com.syzechuan.entity.Category;
import com.syzechuan.result.PageResult;
import com.syzechuan.result.Result;
import com.syzechuan.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/admin/category")
@Api(tags = "Category Api")
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping
    @ApiOperation("Add new Category")
    public Result<String> save(@RequestBody CategoryDTO categoryDTO){
        categoryService.save(categoryDTO);
        return Result.success();
    }


    @GetMapping("/page")
    @ApiOperation("Category List")
    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO){
        PageResult pageResult = categoryService.pageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 删除分类
     * @param id
     * @return
     */
    @DeleteMapping
    @ApiOperation("Delete Category")
    public Result<String> deleteById(Long id){
        categoryService.deleteById(id);
        return Result.success();
    }


    @PutMapping
    @ApiOperation("Update Category")
    public Result<String> update(@RequestBody CategoryDTO categoryDTO){
        categoryService.update(categoryDTO);
        return Result.success();
    }


    @PostMapping("/status/{status}")
    @ApiOperation("Enable/Disable Category")
    public Result<String> startOrStop(@PathVariable("status") Integer status, Long id){
        categoryService.startOrStop(status,id);
        return Result.success();
    }

    @GetMapping("/list")
    @ApiOperation("Category List")
    public Result<List<Category>> list(Integer type){
        List<Category> list = categoryService.list(type);
        return Result.success(list);
    }
}
