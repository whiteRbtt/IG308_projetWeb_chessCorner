package com.IG308.chessCorner.dataAccess.dao;

import com.IG308.chessCorner.model.Order;

public interface OrderDataAccess {
    Order save(Order order);
    Order getOrderById(int id);
}
