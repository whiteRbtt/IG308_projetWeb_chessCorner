package com.IG308.chessCorner.model;

import java.util.ArrayList;

public class Product {

    private Integer productId;
    private Double price;
    private ArrayList<ProductTranslation> productTranslations;

    public Product(){
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public ArrayList<ProductTranslation> getProductTranslations() {
        return productTranslations;
    }

    public void setProductTranslations(ArrayList<ProductTranslation> productTranslations) { this.productTranslations = productTranslations; }


    @Override
    public boolean equals(Object p) {
    	if(p instanceof Product){
            Product product = (Product) p;
            return product.getPrice().equals(this.getPrice());
        }
        return false;
    }
}
