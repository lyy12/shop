package com.liuyuan.gmall.service;

import com.liuyuan.gmall.bean.OrderInfo;

public interface OrderService {


    public  String  saveOrder(OrderInfo orderInfo);

    public  OrderInfo getOrderInfo(String orderId);

    public  String  genToken(String userId);

    public  boolean  verifyToken(String userId,String token);



}
