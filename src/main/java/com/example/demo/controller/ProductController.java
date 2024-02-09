package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.ProductDTO;
import com.example.demo.service.ProductService;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
    private ProductService productService;

 
  

    @PostMapping("/create")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDto) {
        ProductDTO createdProduct = productService.createProduct(productDto);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = productService.getAllProduct();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        ProductDTO product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id)
    {	
    	productService.deleteProduct(id);
		return new ResponseEntity<>("Product ddeleted successfully...", HttpStatus.OK);
    	
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDto) {
        ProductDTO updatedProduct = productService.updateProduct(id, productDto);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }
}
