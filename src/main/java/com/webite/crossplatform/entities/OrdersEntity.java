package com.webite.crossplatform.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrdersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_type_id")
    private PaymentTypesEntity paymentType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private StatusesEntity status;

    private String address;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "orders_has_goods",
            joinColumns = { @JoinColumn(name = "orders_order_id") },
            inverseJoinColumns = { @JoinColumn(name = "goods_goods_id") }
    )
    private List<GoodsEntity> goods;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PaymentTypesEntity getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentTypesEntity paymentType) {
        this.paymentType = paymentType;
    }

    public StatusesEntity getStatus() {
        return status;
    }

    public void setStatus(StatusesEntity status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<GoodsEntity> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsEntity> goods) {
        this.goods = goods;
    }
}