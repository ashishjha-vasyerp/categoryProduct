package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CatagoryDTO;


public interface CatagoryService  {

	CatagoryDTO creatCatagory(CatagoryDTO catagoryDto);
	CatagoryDTO getCategoryById(Long id);
	List<CatagoryDTO> getAllCatagory();
	void deleteCatagory(Long id);
	CatagoryDTO updateCategory(Long id, CatagoryDTO catagoryDto);
}
