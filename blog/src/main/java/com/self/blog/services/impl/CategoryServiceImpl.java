package com.self.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.self.blog.entity.Category;
import com.self.blog.exceptions.ResourceNotFoundException;
import com.self.blog.payloads.CategoryDTO;
import com.self.blog.repository.CategoryRepo;
import com.self.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService  {

	@Autowired
	   private CategoryRepo categoryRepo;
	 
	@Autowired
	private ModelMapper modelMapper;
	
	   @Override
	public CategoryDTO createCat(CategoryDTO cat_DTO) {
		// TODO Auto-generated method stub
		   Category cat=catDTOtocat(cat_DTO);
				   
			Category cat1=	categoryRepo.save(cat);
			
			return cattocatDto(cat1);
				   
//		return null;
	}



	@Override
	public CategoryDTO updateCat(CategoryDTO cat_DTO, Integer CatDto_id) {
		// TODO Auto-generated method stub
		
		
		
		Category cat=categoryRepo.findById(CatDto_id).orElseThrow(()->new ResourceNotFoundException("category","id",CatDto_id));
		cat.setCat_desc(cat_DTO.getCat_desc());	
		cat.setCat_desc(cat_DTO.getCat_desc());   
		cat.setCat_desc(cat_DTO.getCat_desc());
		
		categoryRepo.save(cat);
		
		CategoryDTO categoryDTO=cattocatDto(cat);
		return categoryDTO;
	}

	@Override
	public void  deleteCat(Integer CatDto_id) {
		Category cat=categoryRepo.findById(CatDto_id).orElseThrow(()->new ResourceNotFoundException("category","id",CatDto_id));
		categoryRepo.delete(cat);
	
	}

	@Override
	public CategoryDTO getCat(Integer CatDto_id) {
		Category cat=categoryRepo.findById(CatDto_id).orElseThrow(()->new ResourceNotFoundException("category","id",CatDto_id));
		
		 
		return cattocatDto(cat);
		}

	@Override
	public List<CategoryDTO> getAllCat() {
		// TODO Auto-generated method stub
		  List<Category>tempCategories=  categoryRepo.findAll();		  		
		  return tempCategories.stream().map((cat)->cattocatDto(cat)).collect(Collectors.toList());
		  
	}
	private CategoryDTO cattocatDto(Category cat) {
		// TODO Auto-generated method stub
		
		CategoryDTO categoryDTO= this.modelMapper.map(cat,CategoryDTO.class); 
		return categoryDTO;
	}

	private Category catDTOtocat(CategoryDTO cat_DTO) {
		// TODO Auto-generated method stub
		Category category= this.modelMapper.map(cat_DTO,Category.class); 
		return category;
		
	}
}
