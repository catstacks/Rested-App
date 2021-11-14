package com.qa.rested.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "RestedUser")
@Table(name = "RESTED_USER")
public class RestedUser {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
    @Column(name = "dob", nullable = false)
    private String dob;

    @Column(name = "age", nullable = false)
    private double age;

    @Column(name = "sleep_qaulity", nullable = false)
    private Integer sleepQuality;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "password", length = 100, nullable = true)
    private String password;

    @Column(name = "first_name", length = 20, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 20, nullable = false)
    private String lastName;
	
    @OneToMany(mappedBy = "user")
    private Set<DailySleep> sleep = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Water> water = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<WaterConsumed> waterConsumed = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<ScreenTime> screenTime = new HashSet<>();    
    
    public RestedUser(
    		final Integer id,
    		final String dob,
    		final double age,
    		final Integer sleepQuality,
    		final String email,
    		final String password,
			final String firstName,
			final String lastName) {
		super();
		this.id = id;
		this.dob = dob;
		this.age = age;
		this.sleepQuality = sleepQuality.intValue();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	
	}

	public RestedUser() {
		super();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public Integer getSleepQuality() {
		return sleepQuality;
	}

	public void setSleepQuality(Integer sleepQuality) {
		this.sleepQuality = sleepQuality;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<DailySleep> getSleep() {
		return sleep;
	}

	public void setSleep(Set<DailySleep> sleep) {
		this.sleep = sleep;
	}

	public Set<Water> getWater() {
		return water;
	}

	public void setWater(Set<Water> water) {
		this.water = water;
	}

	public Set<WaterConsumed> getWaterConsumed() {
		return waterConsumed;
	}

	public void setWaterConsumed(Set<WaterConsumed> waterConsumed) {
		this.waterConsumed = waterConsumed;
	}

	public Set<ScreenTime> getScreenTime() {
		return screenTime;
	}

	public void setScreenTime(Set<ScreenTime> screenTime) {
		this.screenTime = screenTime;
	}

	public enum SleepQuality {

        EXTREMELY_POOR(1), POOR(2), AVERAGE(3), GOOD(4), EXCELLENT(5);

        private Integer value;

        SleepQuality(final Integer value) {
            this.value = value;
        }


        public static SleepQuality fromValue(final Integer value) {
        	SleepQuality match = null;
            for (final SleepQuality activityLevel : SleepQuality.values()) {
                if (activityLevel.getValue() == value) {
                    match = activityLevel;
                }
            }
            return match;
        }


        public static SleepQuality fromString(final String str) {
        	SleepQuality match = null;
            for (final SleepQuality activityLevel : SleepQuality.values()) {
                if (activityLevel.toString().equalsIgnoreCase(str)) {
                    match = activityLevel;
                }
            }
            return match;
        }
        
        public Integer getValue() {
            return this.value;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder(super.toString().toLowerCase().replace('_', ' '));
            for (int index = 0; index < sb.length(); index++) {
                if (index == 0 || sb.charAt(index - 1) == ' ') {
                    final String currentCharAsString = Character.toString(sb.charAt(index));
                    sb.replace(index, index + 1, currentCharAsString.toUpperCase());
                }
            }
            return sb.toString();
        }

    }

	
	@Override
    public int hashCode() {
        return this.getId().hashCode()               
                + this.getDob().hashCode()
                + this.getSleepQuality().hashCode()
                + this.getEmail().hashCode()
                + (this.getPassword() == null ? 0 : this.getPassword().hashCode())
                + this.getFirstName().hashCode()
                + this.getLastName().hashCode();
                
    }
}
	
	
	


