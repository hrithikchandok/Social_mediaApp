package com.self.blog.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Category {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer id;
     
     @Column(name="title")
	 private String categoty_title;
     
     @Column(name="description")
	 private String cat_desc;
     
     @OneToMany(mappedBy ="category",cascade = CascadeType.ALL,fetch =FetchType.LAZY )
     private List<Post> posts=new ArrayList<>();
     
}
