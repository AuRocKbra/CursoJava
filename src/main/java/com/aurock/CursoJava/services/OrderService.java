package com.aurock.CursoJava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurock.CursoJava.entities.Order;
import com.aurock.CursoJava.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	public OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
