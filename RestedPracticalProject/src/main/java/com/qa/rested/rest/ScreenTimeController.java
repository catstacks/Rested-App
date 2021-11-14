package com.qa.rested.rest;

import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.rested.domain.ScreenTime;
import com.qa.rested.repos.ScreenTimeRepo;
import com.qa.rested.service.RestedUserService;
import com.qa.rested.service.ScreenTimeService;

@RestController
@RequestMapping("/screen")
public class ScreenTimeController {
	
	private ScreenTimeRepo screenTimeRepository;

	public ScreenTimeController(ScreenTimeRepo screenTimeRepository) {
		super();
		this.screenTimeRepository = screenTimeRepository;
	}
	
	private RestedUserService service;

	@Autowired
	public ScreenTimeController(ScreenTimeService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/addScreen")
	public ScreenTime addScreen(@RequestBody ScreenTime newScreen) {
		return screenTimeRepository.save(newScreen);
	}
	
	@GetMapping("/getScreen/{id}")
	public ScreenTime getScreen(@PathVariable UUID id) {
		return screenTimeRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
	}
	
	@PutMapping("/replaceScreen/{id}")
	public ResponseEntity<ScreenTime> replaceScreen(@PathVariable UUID id, @RequestBody ScreenTime newScreen) {
		ScreenTime body = this.service.replaceScreen(id, newScreen);
		return new ResponseEntity<ScreenTime>(body, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/removeScreen/{id}")
	public ResponseEntity<?> removeScreen(@PathVariable UUID id) {
		boolean removed = this.service.removeScreen(id);
		if (removed) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
		
	
	

}
