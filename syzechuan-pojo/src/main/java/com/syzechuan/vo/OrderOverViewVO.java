package com.syzechuan.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 订单概览数据
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderOverViewVO implements Serializable {
    private Integer waitingOrders;

    private Integer deliveredOrders;

    private Integer completedOrders;

    private Integer cancelledOrders;

    private Integer allOrders;
}
