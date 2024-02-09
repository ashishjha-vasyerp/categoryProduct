package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CatagoryDTO;
import com.example.demo.entity.Catagory;
import com.example.demo.repository.CatagoryRepository;

@Service
public class CategoryServiceImpl implements CatagoryService{

	
	public CategoryServiceImpl(CatagoryRepository catagoryRepository, ModelMapper modelMapper) {
		this.catagoryRepository = catagoryRepository;
		this.modelMapper = modelMapper;
	}

	@Autowired
	CatagoryRepository catagoryRepository;
	@Autowired 
	ModelMapper modelMapper;
	
	@Override
	public CatagoryDTO creatCatagory(CatagoryDTO catagoryDto) {
		// TODO Auto-generated method stub
		Catagory catagory = modelMapper.map(catagoryDto, Catagory.class);
		return modelMapper.map(catagoryRepository.save(catagory), CatagoryDTO.class) ;
	}

	@Override
	public List<CatagoryDTO> getAllCatagory() {
		// TODO Auto-generated method stub
		List<Catagory> catagories = catagoryRepository.findAll();
		return catagories.stream()
				.map(catagory -> modelMapper.map(catagory, CatagoryDTO.class))
				.collect(Collectors.toList());
		
	}

	 @Override
	    public CatagoryDTO getCategoryById(Long id) {
	        Catagory category = catagoryRepository.findById(id)
	                .orElseThrow(() -> new NoSuchElementException("Category not found with id: " + id));
	        return modelMapper.map(category, CatagoryDTO.class);
	    }

	@Override
	public void deleteCatagory(Long id) {
		// TODO Auto-generated method stub
		catagoryRepository.deleteById(id);
		
	}

	@Override
	 public CatagoryDTO updateCategory(Long id, CatagoryDTO catagoryDto) {
        Catagory existingCategory = catagoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Category not found with id: " + id));
        
        existingCategory.setName(catagoryDto.getName());
        
        Catagory updatedCategory = catagoryRepository.save(existingCategory);
        return modelMapper.map(updatedCategory, CatagoryDTO.class);
    }
	
	

}
