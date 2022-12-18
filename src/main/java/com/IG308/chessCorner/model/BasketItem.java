package com.IG308.chessCorner.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class BasketItem {

        private Product product;
        @Min(0)
        @NotNull
        private Integer quantity;

        public BasketItem(){

        }

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
            if(quantity < 0){
                this.quantity = 0;
            } else {
                this.quantity = quantity;
            }
        }
}
