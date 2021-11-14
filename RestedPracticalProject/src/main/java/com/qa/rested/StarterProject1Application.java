package com.qa.rested;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.qa.rested.domain.DailySleep;
import com.qa.rested.domain.DreamJournal;
import com.qa.rested.domain.RestedUser;
import com.qa.rested.domain.ScreenTime;
import com.qa.rested.domain.Water;
import com.qa.rested.domain.WaterConsumed;
import com.qa.rested.domain.WeeklyReportData;
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
		SpringApplication.run(StarterProject1Application.class, args);		}
	
		
	public void run(String... args) throws Exception  {
		
		RestedUser newUser = new RestedUser();
		restedRepository.save(newUser);
		
		DailySleep newSleep = new DailySleep();
		dailySleepRepository.save(newSleep);
		
		DreamJournal newDream = new DreamJournal();
		journalRepository.save(newDream);
		
		ScreenTime newScreen = new ScreenTime();
		screenTimeRepository.save(newScreen);
		
		WaterConsumed newWaterConsumed = new WaterConsumed();
		waterConsumedRepository.save(newWaterConsumed);
		
		Water newWater = new Water();
		waterRepository.save(newWater);
		
		WeeklyReportData newReport = new WeeklyReportData();
		wkReportDataRepository.save(newReport);
		
	}
	

}

// A comment to test the 'test' branch works 