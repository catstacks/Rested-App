package com.qa.rested.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.rested.domain.ScreenTime;

@Repository
public interface ScreenTimeRepo extends JpaRepository<ScreenTime, UUID>{

}
