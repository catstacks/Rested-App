package com.qa.rested.rest;

import java.util.List;


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
import com.qa.rested.service.RestedUserService;

@RestController
@RequestMapping("/rested")
public class RestedController {
	
	private RestedUserService service;

	@Autowired
	public RestedController(RestedUserService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<RestedUser> createUser(@RequestBody RestedUser newUser) {
		RestedUser responseBody = this.service.createUser(newUser);
		return new ResponseEntity<RestedUser>(responseBody, HttpStatus.CREATED);
	}

	@GetMapping("/showAllUsers")
	public ResponseEntity<List<RestedUser>> getUsers() {
		return ResponseEntity.ok(this.service.getUsers());
	}

	@GetMapping("/getUser/{id}")
	public RestedUser getUser(@PathVariable Integer id) {
		return this.service.getUser(id);
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
