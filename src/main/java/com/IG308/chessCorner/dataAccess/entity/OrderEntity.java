package com.IG308.chessCorner.dataAccess.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="orderId")
    private Integer orderId;

    @Column(name="orderDate")
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name="userMail", referencedColumnName="mailAddress")
    private UserEntity userEntity;

    @Column(name="isPaid")
    private Boolean isPaid;

    public OrderEntity(){
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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }
}
