package com.self.blog.controllers;

import java.util.List;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.self.blog.payloads.ApiResponse;
import com.self.blog.payloads.CategoryDTO;
import com.self.blog.services.CategoryService;
import com.self.blog.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CatController 
{
	@Autowired
    private CategoryService categoryService;
	
	
//	Create
	      @PostMapping("/")
	      public   ResponseEntity< CategoryDTO> createCat(@Valid @RequestBody CategoryDTO categoryDTO)
	      { 
	    	   CategoryDTO ansCategoryDTO= categoryService.createCat(categoryDTO);
	    	   return new ResponseEntity<>(ansCategoryDTO,HttpStatus.CREATED);
	      }
	 //	Update
	      @PutMapping("/{cat_id}")
	      public ResponseEntity< CategoryDTO> updateCat(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable Integer cat_id) {	      
	    	  CategoryDTO ansCategoryDTO= categoryService.updateCat(categoryDTO, cat_id);
	    	  return new ResponseEntity<>(ansCategoryDTO,HttpStatus.OK);
	      }
//	getbyId
	      @GetMapping("/{cat_id}")
	      public ResponseEntity< CategoryDTO> getCat(@PathVariable Integer cat_id) {	      
	    	  CategoryDTO ansCategoryDTO= categoryService.getCat( cat_id);
	    	  return new ResponseEntity<>(ansCategoryDTO,HttpStatus.OK);
	      }
//	
	      @GetMapping("/")
	      public ResponseEntity<List<CategoryDTO>> getAllCat() {	      
	    	  List<CategoryDTO>  ansCategoryDTO= categoryService.getAllCat();
	    	  return new ResponseEntity<>(ansCategoryDTO,HttpStatus.OK);
	      }
	      
	      @DeleteMapping("/{cat_id}")
	      public ResponseEntity<ApiResponse> DelByid(@PathVariable Integer cat_id) {	      
	    	  categoryService.deleteCat(cat_id);	  
	    	  return new ResponseEntity<>(new ApiResponse("category Deleted SuccessFully",true),HttpStatus.OK);
	    	  }
	      

}
