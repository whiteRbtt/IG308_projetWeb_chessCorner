package com.IG308.chessCorner.model;

import javax.validation.constraints.*;

public class BasketItem {

    @Min(1)
    @Max(100)
    @NotNull
    private Integer quantity;
    private Product product;

    public BasketItem(){}

    public BasketItem(Product product, Integer quantity){
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BasketItem{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
