package com.IG308.chessCorner.dataAccess.repository;

import com.IG308.chessCorner.dataAccess.entity.OrderLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLineEntity, Integer> {
}

