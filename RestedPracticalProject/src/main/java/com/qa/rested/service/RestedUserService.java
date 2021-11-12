package com.qa.rested.service;

import java.util.List;

import com.qa.rested.domain.RestedUser;
import com.qa.rested.dto.RestedDTO;

public interface RestedUserService {
	
	RestedUser createUser(RestedUser newUser);

	List<RestedUser> getUsers();

	RestedUser getUser(Integer id);

	RestedUser replaceUser(Integer id, RestedUser newUser);

	boolean removeUser(Integer id);

	RestedDTO findByEmail(String attribute);
	}


