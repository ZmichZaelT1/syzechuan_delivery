package com.syzechuan.service;

import com.syzechuan.dto.CategoryDTO;
import com.syzechuan.dto.CategoryPageQueryDTO;
import com.syzechuan.entity.Category;
import com.syzechuan.result.PageResult;
import java.util.List;

public interface CategoryService {

    void save(CategoryDTO categoryDTO);

    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);


    void deleteById(Long id);


    void update(CategoryDTO categoryDTO);

    void startOrStop(Integer status, Long id);

    List<Category> list(Integer type);
}
