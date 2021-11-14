package com.qa.rested.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "weekly_report_data", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "date"}))
public class WeeklyReportData {
	
	 	@Id
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Integer id;

	    @ManyToOne
	    @JoinColumn(name = "user_id", nullable = false)
	    private RestedUser user;

	    @Column(name = "date", nullable = false)
	    private String date;

	    @Column(name = "weekly_sleep", nullable = false)
	    private Double weeklySleep = 0.0;

	    @Column(name = "weekly_water", nullable = false)
	    private Double weeklyWater = 0.0;
	    
	    @Column(name = "weekly_screen_time", nullable = false)
	    private Double weeklyScreenTime = 0.0;

		public WeeklyReportData(
				final Integer id,
				final RestedUser user,
				final String date,
				final Double weeklySleep,
				final Double weeklyWater,
				final Double weeklyScreenTime) {
			
			this.id = id;
			this.user = user;
			this.date = date;
			this.weeklySleep = weeklySleep;
			this.weeklyWater = weeklyWater;
			this.weeklyScreenTime = weeklyScreenTime;
		}
	    
		public WeeklyReportData() {
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

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public Double getWeeklySleep() {
			return weeklySleep;
		}

		public void setWeeklySleep(Double weeklySleep) {
			this.weeklySleep = weeklySleep;
		}

		public Double getWeeklyWater() {
			return weeklyWater;
		}

		public void setWeeklyWater(Double weeklyWater) {
			this.weeklyWater = weeklyWater;
		}

		public Double getWeeklyScreenTime() {
			return weeklyScreenTime;
		}

		public void setWeeklyScreenTime(Double weeklyScreenTime) {
			this.weeklyScreenTime = weeklyScreenTime;
		}
		
		

}
