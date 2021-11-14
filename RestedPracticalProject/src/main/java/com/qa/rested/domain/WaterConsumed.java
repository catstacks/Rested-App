package com.qa.rested.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.qa.rested.domain.Water.ServingSize;

@Entity
@Table(name = "water_consumed", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "water_id", "date"}))

public class WaterConsumed {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private RestedUser user;

    @ManyToOne
    @JoinColumn(name = "water_id", nullable = false)
    private Water water;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "serving_size", length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private Water.ServingSize servingType;

    @Column(name = "serving_amount", nullable = false)
    private Double servingAmount;

	public WaterConsumed(
			final Integer id,
			final RestedUser user,
			final Water water,
			final Date date,
			final ServingSize servingType,
			final Double servingAmount) {
		
		this.id = id;
		this.user = user;
		this.water = water;
		this.date = (Date) date.clone();
		this.servingType = servingType;
		this.servingAmount = servingAmount;
	}
    
	public WaterConsumed() {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RestedUser getUser() {
		return user;
	}

	public void setUser(RestedUser user) {
		this.user = user;
	}

	public Water getWater() {
		return water;
	}

	public void setWater(Water water) {
		this.water = water;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Water.ServingSize getServingType() {
		return servingType;
	}

	public void setServingType(Water.ServingSize servingType) {
		this.servingType = servingType;
	}

	public Double getServingAmount() {
		return servingAmount;
	}

	public void setServingAmount(Double servingAmount) {
		this.servingAmount = servingAmount;
	}
	
	


}

