package com.qa.rested.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.rested.domain.Water;

@Repository
public interface WaterRepo extends JpaRepository<Water, Integer>{

}
