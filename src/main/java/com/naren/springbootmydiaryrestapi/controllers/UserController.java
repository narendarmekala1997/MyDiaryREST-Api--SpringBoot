package com.naren.springbootmydiaryrestapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.naren.springbootmydiaryrestapi.entities.Entry;
import com.naren.springbootmydiaryrestapi.entities.User;
import com.naren.springbootmydiaryrestapi.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	public UserService userService;

	@GetMapping("/users/")
	public List<User> findAll(){
		
		return userService.findAll();
		
	}
	@GetMapping("/users/{id}")
	public User  findById(@PathVariable long id) {
		
		return userService.findById(id);
	}
	@GetMapping("/users1/{username}")
	public User findByUsername(@PathVariable String username)
	{
		return userService.findByUsername(username);
	}
	@PostMapping("/users/")
	public User saveUser(@RequestBody User user) {
		
		User user1 = userService.saveUser(user);
		return user;
	}
	@PutMapping("/users/")
	public User updateUser(@RequestBody User user) {
		
		User updated = userService.updateUser(user);
		return updated;
		
	}
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable("id") long id) {
		
		User user = userService.findById(id);
		userService.deleteUser(user);
	}
}
