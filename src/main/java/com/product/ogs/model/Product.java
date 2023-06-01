package com.product.ogs.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
@Component
public class Product {
	
	@Id
	Integer userId;
	
	List<String> product;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<String> getProduct() {
		return product;
	}

	public void setProduct(List<String> product) {
		this.product = product;
	}

}
