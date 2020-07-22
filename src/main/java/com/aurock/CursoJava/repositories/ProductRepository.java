package com.aurock.CursoJava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurock.CursoJava.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
