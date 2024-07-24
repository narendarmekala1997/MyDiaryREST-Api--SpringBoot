package com.naren.springbootmydiaryrestapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naren.springbootmydiaryrestapi.entities.Entry;

public interface EntryRepository extends JpaRepository<Entry, Long> {
	
	public List<Entry> findByUserid(long id);

	
}
