package com.IG308.chessCorner.dataAccess.dao;

import com.IG308.chessCorner.model.Product;

import java.util.List;

public interface ProductDataAccess {
    Product getProductById(int i);
    List<Product> findAll();
}
