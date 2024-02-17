package com.self.blog.payloads;

//import java.sql.Date;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Validated
public class PostDTO {
	private Integer post_id;
	   
	    private String title;
	    private String content;
	    private String image="default.png";
	    private Date addedDate;
	    
	    private CategoryDTO category;
	    private UserDto user;
	    private Set<CommentDto>comment=new HashSet<>();  
}
