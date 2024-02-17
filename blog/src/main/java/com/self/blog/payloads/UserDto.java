package com.self.blog.payloads;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Validated
public class UserDto {
		
	private Integer id;
@NotEmpty
@Size(min = 3 , message = "Name should contains 3 words")
private String name;
	@Email(message = "Email adress is not valid")
	private String email;
	@NotEmpty
	@Size(min = 3 , message = "Password should contains 3 words")
	private String password;
	@NotEmpty
	@Size(min = 3 , message = "About should contains 3 words")
	private String about;
}
