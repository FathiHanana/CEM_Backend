package com.codingcomrades.CEM_fullstack.repository;

import com.codingcomrades.CEM_fullstack.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
