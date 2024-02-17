package com.self.blog.payloads;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@Validated
public class CategoryDTO {
	
	private Integer id;
	@NotEmpty(message = "categoty_title Cant be Empty")
	 private String categoty_title;
	@NotEmpty(message = "Category Description Cant be Empty")
	 private String cat_desc;
   
}