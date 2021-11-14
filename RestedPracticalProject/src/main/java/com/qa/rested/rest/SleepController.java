package com.qa.rested.rest;

import java.util.NoSuchElementException;

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

import com.qa.rested.domain.DailySleep;
import com.qa.rested.repos.DailySleepRepo;
import com.qa.rested.service.SleepService;

@RestController
@RequestMapping("/sleep")
public class SleepController {
	
	private DailySleepRepo dailySleepRepository;

	public SleepController(DailySleepRepo dailySleepRepository) {
		super();
		this.dailySleepRepository = dailySleepRepository;
	}
	
	private SleepService service;

	@Autowired
	public SleepController(SleepService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/addSleep")
	public DailySleep addSleep(@RequestBody DailySleep newSleep) {
		return dailySleepRepository.save(newSleep);
	}
	
	@GetMapping("/getSleep/{id}")
	public DailySleep getSleep(@PathVariable Integer id) {
		return dailySleepRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
	}
	
	@PutMapping("/replaceSleep/{id}")
	public ResponseEntity<DailySleep> replaceSleep(@PathVariable Integer id, @RequestBody DailySleep newSleep) {
		DailySleep body = this.service.replaceSleep(id, newSleep);
		return new ResponseEntity<DailySleep>(body, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/removeSleep/{id}")
	public ResponseEntity<?> removeSleep(@PathVariable Integer id) {
		boolean removed = this.service.removeSleep(id);
		if (removed) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
