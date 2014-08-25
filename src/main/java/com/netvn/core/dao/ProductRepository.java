package com.netvn.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netvn.core.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
