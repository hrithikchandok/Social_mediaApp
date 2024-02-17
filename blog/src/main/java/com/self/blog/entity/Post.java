package com.self.blog.entity;

//import java.sql.Date;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.self.blog.payloads.CategoryDTO;
import com.self.blog.payloads.CommentDto;
import com.self.blog.payloads.UserDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Post 
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer post_id;
	
    private String title;
    private String content;
    private String image;
    private Date addedDate;
    
     @ManyToOne 
     private Category category;
     
     @ManyToOne
     private User user;
     
     @OneToMany(mappedBy = "post" , cascade=CascadeType.ALL)
     private Set<Comment>comment=new HashSet<>(); 
  }