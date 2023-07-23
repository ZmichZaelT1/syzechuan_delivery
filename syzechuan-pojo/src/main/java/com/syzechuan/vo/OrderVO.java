package com.syzechuan.vo;

import com.syzechuan.entity.OrderDetail;
import com.syzechuan.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderVO extends Orders implements Serializable {

    private String orderDishes;

    private List<OrderDetail> orderDetailList;

}
