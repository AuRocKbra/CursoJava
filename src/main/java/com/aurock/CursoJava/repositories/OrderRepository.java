package com.aurock.CursoJava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurock.CursoJava.entities.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

}
