package com.example.demo.dto;

import com.example.demo.entity.Catagory;

import lombok.Data;

@Data
public class ProductDTO {

	private Long id;
	private String name;
//	private Long categoryId
	private Catagory catagory;; 
}
