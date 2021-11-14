package com.qa.rested.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.qa.rested.domain.DailySleep;
import com.qa.rested.domain.DreamJournal;
import com.qa.rested.domain.RestedUser;
import com.qa.rested.domain.ScreenTime;
import com.qa.rested.domain.Water;
import com.qa.rested.domain.WaterConsumed;
import com.qa.rested.domain.WeeklyReportData;
import com.qa.rested.dto.RestedDTO;

@Service
public class WkReportService implements RestedUserService{

	@Override
	public RestedUser createUser(RestedUser newUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestedDTO findByEmail(String attribute) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DailySleep replaceSleep(UUID id, DailySleep newSleep) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DreamJournal replaceDream(UUID id, DreamJournal newDream) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScreenTime replaceScreen(UUID id, ScreenTime newScreen) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Water replaceWater(UUID id, Water newWater) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WaterConsumed replaceWaterConsumed(UUID id, WaterConsumed newWaterConsumed) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WeeklyReportData replaceReport(UUID id, WeeklyReportData newReport) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeUser(UUID id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeSleep(UUID id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeDream(UUID id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeScreen(UUID id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeWater(UUID id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeWaterConsumed(UUID id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeReport(UUID id) {
		// TODO Auto-generated method stub
		return false;
	}
}
	



