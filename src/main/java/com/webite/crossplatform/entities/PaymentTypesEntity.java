//package com.webite.crossplatform.entities;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "payment_types")
//public class PaymentTypesEntity {
//
//    @Id
//    @Column(name = "payment_id")
//    private int id;
//
//    @Column(name = "payment_type")
//    private String paymentType;
//
//    public PaymentTypesEntity() {
//    }
//
//    public PaymentTypesEntity(String paymentType) {
//        this.paymentType = paymentType;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getPaymentType() {
//        return paymentType;
//    }
//
//    public void setPaymentType(String paymentType) {
//        this.paymentType = paymentType;
//    }
//
//    // getters and setters for all fields
//}