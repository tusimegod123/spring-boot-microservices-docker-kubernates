package com.miu.edu.CS590.order.repository;

import com.miu.edu.CS590.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository  extends JpaRepository<Order, Integer> {
}
