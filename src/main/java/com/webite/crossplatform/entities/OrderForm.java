package com.webite.crossplatform.entities;

import java.math.BigDecimal;
import java.util.List;

public class OrderForm {
    private String deliveryAddress;
    private String paymentType;
    private List<GoodsEntity> orderItems;
    private BigDecimal totalPrice;

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public List<GoodsEntity> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<GoodsEntity> orderItems) {
        this.orderItems = orderItems;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}

