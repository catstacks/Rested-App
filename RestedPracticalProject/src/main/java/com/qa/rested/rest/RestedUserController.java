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
	public RestedUser getUser(@PathVariable Integer id) {
		return restedRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
	}
	
	@PostMapping("/addUser")
	public RestedUser addUser(@RequestBody RestedUser newUser) {
		return restedRepository.save(newUser);
	}
	
	@PostMapping("/addSleep")
	public DailySleep addSleep(@RequestBody DailySleep newSleep) {
		return dailySleepRepository.save(newSleep);
	}
	
	@PostMapping("/addDream")
	public DreamJournal addDream(@RequestBody DreamJournal newDream) {
		return journalRepository.save(newDream);
	}
	
	@PostMapping("/addScreen")
	public ScreenTime addScreen(@RequestBody ScreenTime newScreen) {
		return screenTimeRepository.save(newScreen);
	}
	
	@PostMapping("/addWaterConsumed")
	public WaterConsumed addWaterConsumed(@RequestBody WaterConsumed newWaterConsumed) {
		return waterConsumedRepository.save(newWaterConsumed);
	}
	
	@PostMapping("/addWater")
	public Water addWater(@RequestBody Water newWater) {
		return waterRepository.save(newWater);
	}
	
	@PostMapping("/addReport")
	public WeeklyReportData addReport(@RequestBody WeeklyReportData newReport) {
		return wkReportDataRepository.save(newReport);
	}

	
	@GetMapping("/getSleep/{id}")
	public DailySleep getSleep(@PathVariable Integer id) {
		return dailySleepRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
	}
	
	@GetMapping("/getDream/{id}")
	public DreamJournal getDream(@PathVariable Integer id) {
		return journalRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
	}
	
	@GetMapping("/getScreen/{id}")
	public ScreenTime getScreen(@PathVariable Integer id) {
		return screenTimeRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
	}
	
	@GetMapping("/getWaterConsumed/{id}")
	public WaterConsumed getWaterConsumed(@PathVariable Integer id) {
		return waterConsumedRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
	}
	
	@GetMapping("/getWater/{id}")
	public Water getWater(@PathVariable Integer id) {
		return waterRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
	}
	
	@GetMapping("/getReport/{id}")
	public WeeklyReportData getReport(@PathVariable Integer id) {
		return wkReportDataRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
	}
	
//	@GetMapping("/showAllUsers")
//	public ResponseEntity<List<RestedUser>> getUsers() {
//		return ResponseEntity.ok(this.service.getUsers());
//	}

	
	@PutMapping("/replaceSleep/{id}")
	public ResponseEntity<DailySleep> replaceSleep(@PathVariable Integer id, @RequestBody DailySleep newSleep) {
		DailySleep body = this.service.replaceSleep(id, newSleep);
		return new ResponseEntity<DailySleep>(body, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/replaceDream/{id}")
	public ResponseEntity<DreamJournal> replaceDream(@PathVariable Integer id, @RequestBody DreamJournal newDream) {
		DreamJournal body = this.service.replaceDream(id, newDream);
		return new ResponseEntity<DreamJournal>(body, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/replaceScreen/{id}")
	public ResponseEntity<ScreenTime> replaceScreen(@PathVariable Integer id, @RequestBody ScreenTime newScreen) {
		ScreenTime body = this.service.replaceScreen(id, newScreen);
		return new ResponseEntity<ScreenTime>(body, HttpStatus.ACCEPTED);
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
	
	@PutMapping("/replaceReport/{id}")
	public ResponseEntity<WeeklyReportData> replaceReport(@PathVariable Integer id, @RequestBody WeeklyReportData newReport) {
		WeeklyReportData body = this.service.replaceReport(id, newReport);
		return new ResponseEntity<WeeklyReportData>(body, HttpStatus.ACCEPTED);
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
	@DeleteMapping("/removeSleep/{id}")
	public ResponseEntity<?> removeSleep(@PathVariable Integer id) {
		boolean removed = this.service.removeSleep(id);
		if (removed) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
			
	@DeleteMapping("/removeDream/{id}")
	public ResponseEntity<?> removedream(@PathVariable Integer id) {
		boolean removed = this.service.removeDream(id);
		if (removed) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
				
	@DeleteMapping("/removeScreen/{id}")
	public ResponseEntity<?> removeScreen(@PathVariable Integer id) {
		boolean removed = this.service.removeScreen(id);
		if (removed) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
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
							
	@DeleteMapping("/removeReport/{id}")
	public ResponseEntity<?> removeReport(@PathVariable Integer id) {
		boolean removed = this.service.removeReport(id);
		if (removed) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
}

}
