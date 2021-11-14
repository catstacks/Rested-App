package com.qa.rested.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.rested.domain.WaterConsumed;

@Repository
public interface WaterConsumedRepo extends JpaRepository<WaterConsumed, Integer>{

}
