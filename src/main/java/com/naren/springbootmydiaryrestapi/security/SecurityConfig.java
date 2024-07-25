package com.naren.springbootmydiaryrestapi.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.socket.EnableWebSocketSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	@Bean
	public UserDetailsManager configureDataSource(DataSource datasource) {
		
		UserDetailsManager userDetailsManager = new JdbcUserDetailsManager(datasource);
		return userDetailsManager;
	}
	
	/*@Bean
	public InMemoryUserDetailsManager getudm() {
		
		
		UserDetails user1 = User.builder().username("user1").password("{noop}user1").roles("ADMIN").build();
		UserDetails user2 = User.builder().username("user2").password("{noop}user2").roles("MANAGER","EMPLOYEE").build();
		UserDetails user3 = User.builder().username("user3").password("{noop}user3").roles("EMPLOYEE").build();
		
		
		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(user1,user2,user3);
	
		return inMemoryUserDetailsManager;
	}*/
	
	@Bean
	public SecurityFilterChain authorizeHttpRequests(HttpSecurity http)throws Exception{
		
		http
		.authorizeHttpRequests(
				(authorize)->{
					
					authorize
					.requestMatchers(HttpMethod.DELETE,"/entries/**").hasAuthority("ROLE_ADMIN")
					.requestMatchers(HttpMethod.PUT,"/entries/**").hasAuthority("ROLE_MANAGER")
					.anyRequest().authenticated();
					
				}
				
				)
		.httpBasic()
		.and()
		.csrf().disable();
		return http.build();
	}
	

}






