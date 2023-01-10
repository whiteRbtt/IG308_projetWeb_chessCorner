package com.IG308.chessCorner.dataAccess.dao;

import com.IG308.chessCorner.model.Order;
import com.IG308.chessCorner.model.OrderLine;
import com.IG308.chessCorner.model.Product;

public interface OrderLineDataAccess {
    OrderLine save(OrderLine orderLine);
}
