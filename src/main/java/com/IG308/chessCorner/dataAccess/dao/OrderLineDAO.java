package com.IG308.chessCorner.dataAccess.dao;

import com.IG308.chessCorner.dataAccess.entity.OrderLineEntity;
import com.IG308.chessCorner.dataAccess.repository.OrderLineRepository;
import com.IG308.chessCorner.dataAccess.util.ProviderConverter;
import com.IG308.chessCorner.model.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Transactional
@Service
public class OrderLineDAO implements OrderLineDataAccess{

        private OrderLineRepository orderLineRepository;
        private ProviderConverter providerConverter;

        @Autowired
        public OrderLineDAO(OrderLineRepository orderLineRepository, ProviderConverter providerConverter) {
            this.orderLineRepository = orderLineRepository;
            this.providerConverter = providerConverter;
        }

        @Override
        public OrderLine save(OrderLine orderLine) {
            OrderLineEntity orderLineEntity = providerConverter.orderLineModelToOrderLineEntity(orderLine);
            OrderLineEntity savedOrderLineEntity = orderLineRepository.save(orderLineEntity);
            return providerConverter.orderLineEntityToOrderLineModel(savedOrderLineEntity);
        }
}
