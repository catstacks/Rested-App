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

import com.qa.rested.domain.WeeklyReportData;
import com.qa.rested.repos.WkReportDataRepo;
import com.qa.rested.service.WkReportService;

@RestController
@RequestMapping("/report")
public class WkReportController {
	
	private WkReportDataRepo wkReportDataRepository;	
	
	public WkReportController(WkReportDataRepo wkReportDataRepository) {
		super();
		this.wkReportDataRepository = wkReportDataRepository;
	}

	private WkReportService wkReportService;	
	
	@Autowired
    public WkReportController(WkReportService wkReportService) {
    	super();
    	this.wkReportService = wkReportService;
}
	@PostMapping("/addReport")
	public WeeklyReportData addReport(@RequestBody WeeklyReportData newReport) {
		return wkReportDataRepository.save(newReport);
	}
	
	@GetMapping("/getReport/{id}")
	public WeeklyReportData getReport(@PathVariable Integer id) {
		return wkReportDataRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
	}
	
	@PutMapping("/replaceReport/{id}")
	public ResponseEntity<WeeklyReportData> replaceReport(@PathVariable Integer id, @RequestBody WeeklyReportData newReport) {
		WeeklyReportData body = this.wkReportService.replaceReport(id, newReport);
		return new ResponseEntity<WeeklyReportData>(body, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/removeReport/{id}")
	public ResponseEntity<?> removeReport(@PathVariable Integer id) {
		boolean removed = this.wkReportService.removeReport(id);
		if (removed) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}



}
