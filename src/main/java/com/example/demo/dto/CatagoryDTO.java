package com.example.demo.dto;

import java.util.List;

import lombok.Data;

@Data
public class CatagoryDTO {
	
	private Long id;
	private String name;
	private List<ProductDTO> product;
}
