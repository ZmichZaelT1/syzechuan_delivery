package com.syzechuan.controller.admin;

import com.syzechuan.dto.DishDTO;
import com.syzechuan.dto.DishPageQueryDTO;
import com.syzechuan.entity.Dish;
import com.syzechuan.result.PageResult;
import com.syzechuan.result.Result;
import com.syzechuan.service.DishService;
import com.syzechuan.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/admin/dish")
@Api(tags = "Dish Api")
@Slf4j
public class DishController {

    @Autowired
    private DishService dishService;

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping
    @ApiOperation("Add Dish")
    public Result save(@RequestBody DishDTO dishDTO) {
        dishService.saveWithFlavor(dishDTO);

        String key = "dish_" + dishDTO.getCategoryId();
        clearCache(key);

        return Result.success();
    }

    @GetMapping("/page")
    @ApiOperation("Dish Query")
    public Result<PageResult> page(DishPageQueryDTO dishPageQueryDTO) {
        PageResult pageResult = dishService.pageQuery(dishPageQueryDTO);
        return Result.success(pageResult);
    }


    @DeleteMapping
    @ApiOperation("Delete dish batch")
    public Result delete(@RequestParam List<Long> ids) {
        dishService.deleteBatch(ids);

        clearCache("dish_");

        return Result.success();
    }


    @GetMapping("/{id}")
    public Result<DishVO> getById(@PathVariable Long id) {
        DishVO dishVO = dishService.getByIdWithFlavor(id);
        return Result.success(dishVO);
    }

    @PutMapping()
    @ApiOperation("Dish Edit")
    public Result update(@RequestBody DishDTO dishDTO) {
        dishService.updateWithFlavor(dishDTO);

        clearCache("dish_");

        return Result.success();
    }

//    @PostMapping("/status/{status}")
//    public Result<String> startOrStop(@PathVariable Integer status, Long id) {
//        dishService.startOrStop(status, id);
//        return Result.success();
//    }

    @GetMapping("/list")
    @ApiOperation("根据分类id查询菜品")
    public Result<List<Dish>> list(Long categoryId){
        List<Dish> list = dishService.list(categoryId);
        return Result.success(list);
    }

    private void clearCache(String pattern) {
        Set keys = redisTemplate.keys(pattern);
        redisTemplate.delete(keys);
    }
}
