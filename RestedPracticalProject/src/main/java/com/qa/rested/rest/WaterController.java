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

import com.qa.rested.domain.Water;
import com.qa.rested.domain.WaterConsumed;
import com.qa.rested.repos.WaterConsumedRepo;
import com.qa.rested.repos.WaterRepo;
import com.qa.rested.service.WaterService;

@RestController
@RequestMapping("/water")
public class WaterController {
	
	private WaterConsumedRepo waterConsumedRepository;	
	private WaterRepo waterRepository;
	
	public WaterController(WaterConsumedRepo waterConsumedRepository, WaterRepo waterRepository) {
		super();
		this.waterConsumedRepository = waterConsumedRepository;
		this.waterRepository = waterRepository;
	}
	
	private WaterService service;
	
	@Autowired
	public WaterController(WaterService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/addWaterConsumed")
	public WaterConsumed addWaterConsumed(@RequestBody WaterConsumed newWaterConsumed) {
		return waterConsumedRepository.save(newWaterConsumed);
	}
	
	@PostMapping("/addWater")
	public Water addWater(@RequestBody Water newWater) {
		return waterRepository.save(newWater);
	}
	
	@GetMapping("/getWaterConsumed/{id}")
	public WaterConsumed getWaterConsumed(@PathVariable Integer id) {
		return waterConsumedRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
	}
	
	@GetMapping("/getWater/{id}")
	public Water getWater(@PathVariable Integer id) {
		return waterRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
	}
	
	@PutMapping("/replaceWater/{id}")
	public ResponseEntity<Water> replaceWater(@PathVariable Integer id, @RequestBody Water newWater) {
		Water body = this.service.replaceWater(id, newWater);
		return new ResponseEntity<Water>(body, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/replaceWaterConsumed/{id}")
	public ResponseEntity<WaterConsumed> replaceWaterConsumed(@PathVariable Integer id, @RequestBody WaterConsumed newWaterConsumed) {
		WaterConsumed body = this.service.replaceWaterConsumed(id, newWaterConsumed);
		return new ResponseEntity<WaterConsumed>(body, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/removeWater/{id}")
	public ResponseEntity<?> removeWater(@PathVariable Integer id) {
		boolean removed = this.service.removeWater(id);
		if (removed) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
						
	@DeleteMapping("/removeWaterConsumed/{id}")
	public ResponseEntity<?> removeWaterConsumed(@PathVariable Integer id) {
		boolean removed = this.service.removeWaterConsumed(id);
		if (removed) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
