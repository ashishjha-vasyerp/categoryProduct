package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.CatagoryDTO;
import com.example.demo.service.CatagoryService;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
    private  CatagoryService catagoryService;
    

	@PostMapping("/create")
    public ResponseEntity<CatagoryDTO> createCategory(@RequestBody CatagoryDTO catagoryDto) {
        CatagoryDTO createdCategory = catagoryService.creatCatagory(catagoryDto);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CatagoryDTO>> getAllCategories() {
        List<CatagoryDTO> categories = catagoryService.getAllCatagory();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CatagoryDTO> getCategoryById(@PathVariable Long id) {
        CatagoryDTO category = catagoryService.getCategoryById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(Long id)
    {
    	catagoryService.deleteCatagory(id);
    	return new ResponseEntity<>("Category deleted successfully..",HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<CatagoryDTO> updateCategory(@PathVariable Long id, @RequestBody CatagoryDTO catagoryDto) {
        CatagoryDTO updatedCategory = catagoryService.updateCategory(id, catagoryDto);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }
}
