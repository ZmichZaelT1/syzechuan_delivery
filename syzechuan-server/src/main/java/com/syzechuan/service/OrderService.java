package com.syzechuan.service;

import com.syzechuan.dto.OrdersPaymentDTO;
import com.syzechuan.dto.OrdersSubmitDTO;
import com.syzechuan.vo.OrderPaymentVO;
import com.syzechuan.vo.OrderSubmitVO;

public interface OrderService {
    OrderSubmitVO submitOrder(OrdersSubmitDTO ordersSubmitDTO);

    OrderPaymentVO payment(OrdersPaymentDTO ordersPaymentDTO) throws Exception;

    void paySuccess(String outTradeNo);
}
