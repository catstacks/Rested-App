package com.qa.rested.service;

import java.util.List;
import java.util.UUID;

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

	List<RestedUser> getUsers();

	RestedUser getUser(Integer id);

	RestedUser replaceUser(Integer id, RestedUser newUser);

	boolean removeUser(Integer id);

	RestedDTO findByEmail(String attribute);

	DailySleep replaceSleep(UUID id, DailySleep newSleep);

	DreamJournal replaceDream(UUID id, DreamJournal newDream);

	ScreenTime replaceScreen(UUID id, ScreenTime newScreen);

	Water replaceWater(UUID id, Water newWater);

	WaterConsumed replaceWaterConsumed(UUID id, WaterConsumed newWaterConsumed);

	WeeklyReportData replaceReport(UUID id, WeeklyReportData newReport);
	}


