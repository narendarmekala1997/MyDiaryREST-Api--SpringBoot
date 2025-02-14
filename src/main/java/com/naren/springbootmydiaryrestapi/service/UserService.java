package com.naren.springbootmydiaryrestapi.service;

import java.util.List;

import com.naren.springbootmydiaryrestapi.entities.User;

public interface UserService {

	public User saveUser(User user);
	public User updateUser(User user);
	public void deleteUser(User user);
	public User findById(long id);
	public List<User> findAll();
	public User findByUsername(String username);
}
