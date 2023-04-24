package com.product.ogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.ogs.model.Product;

@Repository
public interface OgsRepository extends JpaRepository<Product, Integer>{

}
