package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ProductDTO;

public interface ProductService {
	
	ProductDTO createProduct(ProductDTO productDto);
	ProductDTO getProductById(Long id);
	List<ProductDTO> getAllProduct();
	void deleteProduct(Long id);
	ProductDTO updateProduct(Long id, ProductDTO productDto);
	
	

}
