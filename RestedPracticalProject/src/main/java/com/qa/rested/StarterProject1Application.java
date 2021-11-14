package com.qa.rested;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.qa.rested.repos.DailySleepRepo;
import com.qa.rested.repos.JournalRepo;
import com.qa.rested.repos.RestedRepo;
import com.qa.rested.repos.ScreenTimeRepo;
import com.qa.rested.repos.WaterConsumedRepo;
import com.qa.rested.repos.WaterRepo;
import com.qa.rested.repos.WkReportDataRepo;

@SpringBootApplication
public class StarterProject1Application {
	
	@Autowired
	private RestedRepo restedRepository;
	@Autowired
	private DailySleepRepo dailySleepRepository;
	@Autowired
	private JournalRepo journalRepository;
	@Autowired
	private ScreenTimeRepo screenTimeRepository;
	@Autowired
	private WaterConsumedRepo waterConsumedRepository;
	@Autowired
	private WaterRepo waterRepository;
	@Autowired
	private WkReportDataRepo wkReportDataRepository;

	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(StarterProject1Application.class, args);	
		
	}
	

}

// A comment to test the 'test' branch works 