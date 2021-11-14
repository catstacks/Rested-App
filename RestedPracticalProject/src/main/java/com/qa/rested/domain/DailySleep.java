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
import java.sql.Date;

@Entity
@Table(name = "daily_sleep", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "journal_id", "date"})
)
public class DailySleep {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private RestedUser user;

    @ManyToOne
    @JoinColumn(name = "journal_id", nullable = false)
    private DreamJournal dreamjournal;

    @Column(name = "date", nullable = false)
    private Date date;
    
    @Column(name = "hours", nullable = false)
    private Integer hours;

    @Column(name = "minutes", nullable = false)
    private Integer minutes;

	public DailySleep(
			final Integer id,
			final RestedUser user,
			final DreamJournal dreamjournal,
			final Date date,
			final Integer hours,
			final Integer minutes) {
		
		this.id = id;
		this.user = user;
		this.dreamjournal = dreamjournal;
		this.date = (Date) date.clone();
		this.hours = hours;
		this.minutes = minutes;
	}
	
	 public DailySleep() {
		 super();
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

	public DreamJournal getDreamJournal() {
		return dreamjournal;
	}

	public void setDreamJournal(DreamJournal dreamjournal) {
		this.dreamjournal = dreamjournal;
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
