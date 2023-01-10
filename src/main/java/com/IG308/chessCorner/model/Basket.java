package com.IG308.chessCorner.model;
import com.IG308.chessCorner.Constants;
import java.util.HashMap;

public class Basket {

        private HashMap<Integer, BasketItem> basketProducts;

        public Basket(){
            this.basketProducts = new HashMap<Integer, BasketItem>();
        }

        public HashMap<Integer, BasketItem> getBasketProducts() {
            return basketProducts;
        }

        public void addProduct(BasketItem basketItem){
            if(basketProducts.containsKey(basketItem.getProduct().getProductId())){
                if(basketProducts.get(basketItem.getProduct().getProductId()).getQuantity() + basketItem.getQuantity() > Constants.STOCK){
                    basketProducts.get(basketItem.getProduct().getProductId()).setQuantity(Constants.STOCK);
                }
                else {
                    basketProducts.get(basketItem.getProduct().getProductId()).setQuantity(basketProducts.get(basketItem.getProduct().getProductId()).getQuantity() + basketItem.getQuantity());
                }
            } else {
                basketProducts.put(basketItem.getProduct().getProductId(), basketItem);
            }
        }
}
