package com.syzechuan.service;

import com.syzechuan.dto.ShoppingCartDTO;
import com.syzechuan.entity.ShoppingCart;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShoppintCartService {
    void addShoppingCart(ShoppingCartDTO shoppingCartDTO);

    List<ShoppingCart> showShoppingCart();

    void cleanShoppingCart();
}
