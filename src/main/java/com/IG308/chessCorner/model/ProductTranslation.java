package com.IG308.chessCorner.model;

public class ProductTranslation {

    private Product product;
    private Language language;
    private String productName;
    private String productDescription;

    public ProductTranslation() {

    }

    public Product getProduct() {
    	return product;
    }

    public void setProduct(Product product) {
    	this.product = product;
    }

    public Language getLanguage() {
    	return language;
    }

    public void setLanguage(Language language) {
    	this.language = language;
    }

    public String getProductName() {
    	return productName;
    }

    public void setProductName(String productName) {
    	this.productName = productName;
    }

    public String getProductDescription() {
    	return productDescription;
    }

    public void setProductDescription(String productDescription) {
    	this.productDescription = productDescription;
    }
}
