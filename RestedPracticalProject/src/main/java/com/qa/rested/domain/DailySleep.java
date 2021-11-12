package com.qa.rested.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.sql.Date;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "daily_sleep", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "sleep_id", "date"})
)
public class DailySleep {
	
	@Id
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private RestedUser user;

    @ManyToOne
    @JoinColumn(name = "sleep_id", nullable = false)
    private Sleep sleep;

    @Column(name = "date", nullable = false)
    private Date date;
    
    @Column(name = "hours", nullable = false)
    private Integer hours;

    @Column(name = "minutes", nullable = false)
    private Integer minutes;

	public DailySleep(
			final UUID id,
			final RestedUser user,
			final Sleep sleep,
			final Date date,
			final Integer hours,
			final Integer minutes) {
		
		this.id = Optional.ofNullable(id).orElse(UUID.randomUUID());
		this.user = user;
		this.sleep = sleep;
		this.date = (Date) date.clone();
		this.hours = hours;
		this.minutes = minutes;
	}
	
	 public DailySleep() {
	    }

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public RestedUser getUser() {
		return user;
	}

	public void setUser(RestedUser user) {
		this.user = user;
	}

	public Sleep getSleep() {
		return sleep;
	}

	public void setSleep(Sleep sleep) {
		this.sleep = sleep;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public Integer getMinutes() {
		return minutes;
	}

	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}
	 
	 
    
    

}
