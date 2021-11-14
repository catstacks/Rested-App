package com.qa.rested.rest;

import java.util.List;
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

import com.qa.rested.domain.RestedUser;
import com.qa.rested.repos.DailySleepRepo;
import com.qa.rested.repos.JournalRepo;
import com.qa.rested.repos.RestedRepo;
import com.qa.rested.repos.ScreenTimeRepo;
import com.qa.rested.repos.WaterConsumedRepo;
import com.qa.rested.repos.WaterRepo;
import com.qa.rested.repos.WkReportDataRepo;
import com.qa.rested.service.RestedUserService;

@RestController
@RequestMapping("/user")
public class RestedUserController {
	
	
	private RestedRepo restedRepository;	
	private DailySleepRepo dailySleepRepository;	
	private JournalRepo journalRepository;	
	private ScreenTimeRepo screenTimeRepository;	
	private WaterConsumedRepo waterConsumedRepository;	
	private WaterRepo waterRepository;	
	private WkReportDataRepo wkReportDataRepository;
	
	
	
	public RestedUserController(
			RestedRepo restedRepository,
			DailySleepRepo dailySleepRepository,
			JournalRepo journalRepository,
			ScreenTimeRepo screenTimeRepository,
			WaterConsumedRepo waterConsumedRepository,
			WaterRepo waterRepository,
			WkReportDataRepo wkReportDataRepository) {
		
		this.restedRepository = restedRepository;
		this.dailySleepRepository = dailySleepRepository;
		this.journalRepository = journalRepository;
		this.screenTimeRepository = screenTimeRepository;
		this.waterConsumedRepository = waterConsumedRepository;
		this.waterRepository = waterRepository;
		this.wkReportDataRepository = wkReportDataRepository;
	}

	private RestedUserService service;

	@Autowired
	public RestedUserController(RestedUserService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/getUser/{id}")
	public RestedUser getUser(@PathVariable UUID id) {
		return restedRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
	}
	
	@PostMapping("/addUser")
	public RestedUser addUser(@RequestBody RestedUser newUser) {
		return restedRepository.save(newUser);
	}

	@GetMapping("/showAllUsers")
	public ResponseEntity<List<RestedUser>> getUsers() {
		return ResponseEntity.ok(this.service.getUsers());
	}

	

	@PutMapping("/replaceUser/{id}")
	public ResponseEntity<RestedUser> replaceUser(@PathVariable Integer id, @RequestBody RestedUser newUser) {
		RestedUser body = this.service.replaceUser(id, newUser);
		return new ResponseEntity<RestedUser>(body, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/removeUser/{id}")
	public ResponseEntity<?> removeUser(@PathVariable Integer id) {
		boolean removed = this.service.removeUser(id);
		if (removed) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
