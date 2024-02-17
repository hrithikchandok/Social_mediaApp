package com.self.blog.services;

import java.util.List;

import com.self.blog.payloads.CategoryDTO;


public interface CategoryService {
    //  create 
	     CategoryDTO createCat(CategoryDTO cat_DTO);	
	     //update 
	     CategoryDTO updateCat(CategoryDTO cat_DTO,Integer CatDto_id);
	// delete 
	     void deleteCat (Integer CatDto_id);
	// get 
	     CategoryDTO getCat(Integer CatDto_id);
	// get all
      List<CategoryDTO> getAllCat();
      }
