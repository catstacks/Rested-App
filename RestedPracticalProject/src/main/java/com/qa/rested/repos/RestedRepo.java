package com.qa.rested.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.rested.domain.RestedUser;

@Repository
public interface RestedRepo extends JpaRepository<RestedUser, Long>{

}
