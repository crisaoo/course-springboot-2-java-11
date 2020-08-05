package com.pescaria.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pescaria.course.entities.OrderItem;
import com.pescaria.course.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {}
