package com.IG308.chessCorner.model;

public class OrderLine {

    private Product product;
    private Order order;
    private Integer quantity;
    private Double price;

    public OrderLine(){

    }

    public OrderLine(Product product, Order order, Integer quantity, Double price){
        this.product = product;
        this.order = order;
        this.quantity = quantity;
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
