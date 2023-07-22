package com.syzechuan.service;

import com.syzechuan.dto.SetmealDTO;
import com.syzechuan.dto.SetmealPageQueryDTO;
import com.syzechuan.entity.Setmeal;
import com.syzechuan.result.PageResult;
import com.syzechuan.vo.DishItemVO;
import com.syzechuan.vo.SetmealVO;

import java.util.List;

public interface SetmealService {
    void saveWithDish(SetmealDTO setmealDTO);

    PageResult pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    void deleteBatch(List<Long> ids);

    SetmealVO getByIdWithDish(Long id);

    void update(SetmealDTO setmealDTO);

    void startOrStop(Integer status, Long id);

    List<DishItemVO> getDishItemById(Long id);

    List<Setmeal> list(Setmeal setmeal);
}
