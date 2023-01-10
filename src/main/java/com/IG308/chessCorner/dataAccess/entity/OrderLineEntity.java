package com.IG308.chessCorner.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="order_line")
public class OrderLineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="orderlineid")
    private Integer orderLineId;

    @JoinColumn(name="orderid", referencedColumnName = "orderid")
    @ManyToOne(fetch = FetchType.LAZY)
    private OrderEntity orderEntity;

    @JoinColumn(name="productid", referencedColumnName = "productid")
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductEntity productEntity;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name="price")
    private Double price;

    public OrderLineEntity(){

    }

    public Integer getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(Integer orderLineId) {
        this.orderLineId = orderLineId;
    }


    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }


    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
