package com.syzechuan.controller.user;

import com.syzechuan.dto.ShoppingCartDTO;
import com.syzechuan.entity.ShoppingCart;
import com.syzechuan.result.Result;
import com.syzechuan.service.ShoppintCartService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/shoppingCart")
@Slf4j
@Api(tags = "ShoppingCart Api")
public class ShoppingCartController {

    @Autowired
    private ShoppintCartService shoppintCartService;

    @PostMapping("/add")
    public Result add(@RequestBody ShoppingCartDTO shoppingCartDTO) {
        shoppintCartService.addShoppingCart(shoppingCartDTO);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<List<ShoppingCart>> list() {
        List<ShoppingCart> list = shoppintCartService.showShoppingCart();
        return Result.success(list);
    }

    @DeleteMapping("/clean")
    public Result clean() {
        shoppintCartService.cleanShoppingCart();
        return Result.success();
    }

}
