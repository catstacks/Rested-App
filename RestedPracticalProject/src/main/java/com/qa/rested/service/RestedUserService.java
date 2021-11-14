package com.qa.rested.service;

import com.qa.rested.domain.DailySleep;
import com.qa.rested.domain.DreamJournal;
import com.qa.rested.domain.RestedUser;
import com.qa.rested.domain.ScreenTime;
import com.qa.rested.domain.Water;
import com.qa.rested.domain.WaterConsumed;
import com.qa.rested.domain.WeeklyReportData;
import com.qa.rested.dto.RestedDTO;

public interface RestedUserService {
	
	RestedUser createUser(RestedUser newUser);

//	List<RestedUser> getUsers();
//
//	RestedUser getUser(Integer id);	

	RestedDTO findByEmail(String attribute);

	DailySleep replaceSleep(Integer id, DailySleep newSleep);

	DreamJournal replaceDream(Integer id, DreamJournal newDream);

	ScreenTime replaceScreen(Integer id, ScreenTime newScreen);

	Water replaceWater(Integer id, Water newWater);

	WaterConsumed replaceWaterConsumed(Integer id, WaterConsumed newWaterConsumed);

	WeeklyReportData replaceReport(Integer id, WeeklyReportData newReport);
	
	boolean removeUser(Integer id);

	boolean removeSleep(Integer id);

	boolean removeDream(Integer id);

	boolean removeScreen(Integer id);

	boolean removeWater(Integer id);

	boolean removeWaterConsumed(Integer id);

	boolean removeReport(Integer id);
	}


