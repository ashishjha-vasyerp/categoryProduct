package com.example.demo.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Catagory;
import com.example.demo.entity.Product;
import com.example.demo.repository.CatagoryRepository;
import com.example.demo.repository.ProductRepository;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	CatagoryRepository catagoryRepository;

//	public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
//		this.productRepository = productRepository;
//		this.modelMapper = modelMapper;
//	}

	@Override
	public List<ProductDTO> getAllProduct() {
		List<Product> products = productRepository.findAll();
		return products.stream().map(product -> modelMapper.map(product, ProductDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public ProductDTO getProductById(Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Product not found with id: " + id));
		return modelMapper.map(product, ProductDTO.class);
	}

	@Override
	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
	}

	@Override
	public ProductDTO updateProduct(Long id, ProductDTO productDto) {
		Product existingProduct = productRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Product not found with id: " + id));

		existingProduct.setName(productDto.getName());

		Product updatedProduct = productRepository.save(existingProduct);
		return modelMapper.map(updatedProduct, ProductDTO.class);
	}

	@Override
	public ProductDTO createProduct(ProductDTO productDto) {
	    Product product = modelMapper.map(productDto, Product.class);
	
	    // Retrieve the category based on categoryId and set it to the product
	    if (productDto.getCatagory().getId() != null) {
	        Catagory category = catagoryRepository.findById(productDto.getCatagory().getId()).orElse(null);
	        product.setCatagory(category);
	    }
	
	    return modelMapper.map(productRepository.save(product), ProductDTO.class);
	}
//	@Override
//	public ProductDTO createProduct(ProductDTO productDto) {
//		Product product = new Product();
//		product.setId(productDto.getId());
//		product.setName(productDto.getName());
//
//		// Retrieve the category based on categoryId and set it to the product
//		if (productDto.getCategoryId() != null) {
//			Catagory category = catagoryRepository.findById(productDto.getCategoryId()).orElse(null);
//			product.setCatagory(category);
//		}
//
//		// Save the product entity
//		product = productRepository.save(product);
//
//		// Convert the saved product entity back to ProductDTO
//		ProductDTO savedProductDto = new ProductDTO();
//		savedProductDto.setId(product.getId());
//		savedProductDto.setName(product.getName());
//		if (product.getCatagory() != null) {
//			savedProductDto.setCategoryId(product.getCatagory().getId());
//		}
//
//		return savedProductDto;
//	}

}
