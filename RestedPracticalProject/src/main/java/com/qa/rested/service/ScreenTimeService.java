package com.qa.rested.service;

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
public class ScreenTimeService implements RestedUserService {

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
	public DailySleep replaceSleep(Integer id, DailySleep newSleep) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DreamJournal replaceDream(Integer id, DreamJournal newDream) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScreenTime replaceScreen(Integer id, ScreenTime newScreen) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Water replaceWater(Integer id, Water newWater) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WaterConsumed replaceWaterConsumed(Integer id, WaterConsumed newWaterConsumed) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WeeklyReportData replaceReport(Integer id, WeeklyReportData newReport) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeUser(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeSleep(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeDream(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeScreen(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeWater(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeWaterConsumed(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeReport(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
