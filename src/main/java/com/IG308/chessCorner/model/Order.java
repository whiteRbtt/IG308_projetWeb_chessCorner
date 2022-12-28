package com.IG308.chessCorner.model;

import java.util.Date;

public class Order {

    private Integer orderId;
    private Date orderDate;
    private User user;
    private Boolean isPaid;

    public Order(){

    }

    public Order(Date orderDate, User user, Boolean isPaid) {
        this.orderDate = orderDate;
        this.user = user;
        this.isPaid = isPaid;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }

}
