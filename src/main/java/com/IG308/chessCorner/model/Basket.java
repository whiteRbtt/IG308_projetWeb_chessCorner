package com.IG308.chessCorner.model;

import java.util.HashMap;

public class Basket {

        private HashMap<Integer, BasketItem> basketProducts;

        public Basket(){
            this.basketProducts = new HashMap<Integer, BasketItem>();
        }

        public HashMap<Integer, BasketItem> getBasketProducts() {
            return basketProducts;
        }

        public void setBasketProducts(HashMap<Integer, BasketItem> basketProducts) {
            this.basketProducts = basketProducts;
        }
}
