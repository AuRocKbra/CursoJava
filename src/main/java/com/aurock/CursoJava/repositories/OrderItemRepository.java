package com.aurock.CursoJava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurock.CursoJava.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
