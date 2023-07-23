package com.syzechuan.service;

import com.syzechuan.dto.DishDTO;
import com.syzechuan.dto.DishPageQueryDTO;
import com.syzechuan.entity.Dish;
import com.syzechuan.result.PageResult;
import com.syzechuan.vo.DishVO;

import java.util.List;

public interface DishService {

    void saveWithFlavor(DishDTO dishDTO);

    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

    void deleteBatch(List<Long> ids);

    DishVO getByIdWithFlavor(Long id);

    void updateWithFlavor(DishDTO dishDTO);

    List<Dish> list(Long categoryId);

    List<DishVO> listWithFlavor(Dish dish);

}
