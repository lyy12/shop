package com.liuyuan.gmall.service;

import com.liuyuan.gmall.bean.PaymentInfo;

public interface PaymentInfoService {

    public void savePaymentInfo(PaymentInfo paymentInfo);

    public PaymentInfo  getPaymentInfo(PaymentInfo paymentInfo);

    public void updatePaymentInfoByOutTradeNo(String outTradeNo,PaymentInfo paymentInfo);

    public  void sendPaymentToOrder(String orderId,String result) ;

    public void sendDelayPaymentResult(String outTradeNo,Long delaySec ,Integer checkCount);

    }