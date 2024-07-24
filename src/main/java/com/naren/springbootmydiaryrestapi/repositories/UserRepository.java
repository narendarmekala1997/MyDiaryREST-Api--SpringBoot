package com.naren.springbootmydiaryrestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naren.springbootmydiaryrestapi.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUsername(String username);
}
