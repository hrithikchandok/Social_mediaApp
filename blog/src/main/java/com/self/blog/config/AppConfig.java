package com.self.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {
 
//	@Bean
//	public UserDetailsService userDetailsService() {
//	     
//		  UserDetails user=User.builder().username("hrithik").password(passwordEncoder().encode("chandok")).roles("admin").build();
//		  UserDetails user1=User.builder().username("bharti").password(passwordEncoder().encode("chandok")).roles("user").build();
//		  return new InMemoryUserDetailsManager(user,user1);
//	  }
	@Bean 
	public PasswordEncoder passwordEncoder() 
	{
		 return new BCryptPasswordEncoder();	
		 }
	
	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
	}