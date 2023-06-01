package com.product.ogs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.product.ogs.model.Product;
import com.product.ogs.repository.OgsRepository;

@Service
public class OgsService {

	OgsRepository ogsRepo;
	
	public OgsService(OgsRepository ogsrepo) {
		this.ogsRepo = ogsrepo;
	}
	
	public Integer addProduct(Product products) {
		
		ogsRepo.save(products);

		return products.getUserId();

	}

	public List<String> getProducts(Integer uid) {
		
		List<String> lst = new ArrayList<String>();
		
		try {
			lst = ogsRepo.findById(uid).get().getProduct();
		}catch (Exception e) {
			throw new RuntimeException("No Data Found for this user");
		}

		return lst;
	}

	public void deleteProduct(Integer uid, Product product) {

		Product prds = ogsRepo.findById(product.getUserId()).get();
		prds.getProduct().removeAll(product.getProduct());
		ogsRepo.save(prds);

	}
	
	public void updateProductsData(Integer uid, Product products) {

		Product existingProducts = ogsRepo.findById(uid).get();
		products.getProduct().addAll(existingProducts.getProduct());

		ogsRepo.deleteById(products.getUserId());
		ogsRepo.save(products);

	}

}
