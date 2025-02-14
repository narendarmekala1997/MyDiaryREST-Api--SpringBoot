package com.naren.springbootmydiaryrestapi.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.naren.springbootmydiaryrestapi.entities.Entry;
import com.naren.springbootmydiaryrestapi.repositories.EntryRepository;
import com.naren.springbootmydiaryrestapi.service.EntryService;

@RestController
public class EntryController {

	@Autowired
	private EntryService entryService;
	
	@GetMapping("/entries/")
	public List<Entry> findAllEntries() {
		
		List<Entry> entrieslist = entryService.findAll();	
		return entrieslist;
		
	} 
	
	@PostMapping("/entries/")
	public Entry saveEntry(@RequestBody Entry entry) {
		
		Entry entry1 = entryService.saveEntry(entry);
		
		return entry1;
		
	}
	@PutMapping("/entries/")
	public Entry updateEntry(@RequestBody Entry entry) {
		
		Entry updated = entryService.updateEntry(entry);
		return updated;
		
	}
	@PutMapping("/entries/{id}")
	public Entry updateEntry1(@PathVariable("id") long id, @RequestBody Entry entry) {
		
		Entry entry1 = entryService.findById(id);
		String desc = entry.getDescription();
		if(null != desc && desc.length()>0 )
			entry1.setDescription(desc);
		entry1.setEntryDate(entry.getDate());
		entry1.setUserid(entry.getUserid());
		Entry updated = entryService.updateEntry(entry);
		return updated;
		
	}
	
	@GetMapping("/entries/{id}")
	public Entry getEntry(@PathVariable("id") long id) {
		
		Entry entry = entryService.findById(id);
		return entry;
	}
	@DeleteMapping("/entries/{id}")
	public void deleteEntry(@PathVariable("id") long id) {
		
		Entry entry = entryService.findById(id);
		entryService.deleteEntry(entry);
	}
	@PatchMapping("/entries/{id}")
	public Entry patchEntry(@PathVariable long id, @RequestBody Entry entry) {
		
		Entry entry1 = entryService.findById(id);
		String desc = entry.getDescription();
		Date date = entry.getDate();
		long usrid = entry.getUserid();
		if(null != desc && desc.length()>0 )
			entry1.setDescription(desc);
		if(date !=null )
			entry1.setEntryDate(date);
		if(usrid>0)
			entry1.setUserid(usrid);
		Entry updated = entryService.updateEntry(entry1);
		
		return updated;
		
	}
}
