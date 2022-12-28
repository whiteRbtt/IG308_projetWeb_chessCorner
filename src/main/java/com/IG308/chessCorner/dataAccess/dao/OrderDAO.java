package com.IG308.chessCorner.dataAccess.dao;

import com.IG308.chessCorner.dataAccess.entity.OrderEntity;
import com.IG308.chessCorner.dataAccess.repository.OrderRepository;
import com.IG308.chessCorner.dataAccess.util.ProviderConverter;
import com.IG308.chessCorner.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Transactional
@Service
public class OrderDAO implements OrderDataAccess{
    private OrderRepository orderRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public OrderDAO(OrderRepository orderRepository, ProviderConverter providerConverter) {
        this.orderRepository = orderRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public Order save(Order order) {
        OrderEntity orderEntity = providerConverter.orderModelToOrderEntity(order);
        OrderEntity savedOrderEntity = orderRepository.save(orderEntity);
        return providerConverter.orderEntityToOrderModel(savedOrderEntity);
    }

    public Order getOrderById(int id) {
        return providerConverter.orderEntityToOrderModel(orderRepository.getById(id));
    }

}
