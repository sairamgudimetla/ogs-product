package com.product.ogs.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.product.ogs.model.Product;
import com.product.ogs.service.OgsService;

@RestController
public class OgsController {
	
	@Autowired
	private OgsService ogsService;
	
	@PostMapping("/api/addProducts")
	public Integer addProducts(@RequestBody Product products) {

		return ogsService.addProduct(products);

	}
	
	@GetMapping("/api/getProducts/{userId}")
	public List<String> getProducts(@PathVariable("userId") Integer uid) {
	
		return ogsService.getProducts(uid);
	
	}
	
	@PostMapping("/api/updateProducts/{userId}")
	public void updateProductsList(@PathVariable("userId") Integer uid, @RequestBody Product product) {
		
		ogsService.updateProductsData(uid, product);
		
	}
	
	@DeleteMapping("/api/deleteProduct/{userId}")
	public void deleteProduct(@PathVariable("userId") Integer uid, @RequestBody Product product) {
		
		ogsService.deleteProduct(uid, product);
		
	}

}
