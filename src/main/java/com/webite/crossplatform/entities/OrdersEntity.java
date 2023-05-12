package com.webite.crossplatform.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "orders")
public class OrdersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer id;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "payment_type_id")
    private int paymentType;

    @Column(name = "status_id")
    private int status;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "ordersEntity")
    private List<OrdersHasGoodsEntity> ordersHasGoodsList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getStatus() {
        return status;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<OrdersHasGoodsEntity> getOrdersHasGoodsList() {
        return ordersHasGoodsList;
    }

    public void setOrdersHasGoodsList(List<OrdersHasGoodsEntity> ordersHasGoodsList) {
        this.ordersHasGoodsList = ordersHasGoodsList;
    }
}