package com.qa.rested.dto;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public final class RestedDTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonIgnore private Integer id;
	private Date dob;
	private double age;
	private Integer sleepQuality;
	private String email;
	private String password;
	private String firstName;
	private String lastName;

    public RestedDTO(
    		final Integer id,
    		final Date dob,
    		final double age,
    		final Integer sleepQuality,
    		final String email,
    		final String password,
    		final String firstName,
    		final String lastName
    ) 
    
    {	this.id = id;
    	this.dob = (Date) dob.clone();
    	this.age =age;
    	this.sleepQuality = sleepQuality;
    	this.email = email;
    	this.password = password;
    	this.firstName = firstName;
    	this.lastName = lastName;
    }

    public RestedDTO() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }


    public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }



    @Override
    public boolean equals(final Object other) {
        boolean equals = false;
        if (other instanceof RestedDTO) {
            final RestedDTO that = (RestedDTO) other;
            equals = this.getId().equals(that.getId())                 
                    && this.getDob().toString().equals(that.getDob().toString())
                    && this.getAge() == that.getAge()
                    && this.getSleepQuality() == that.getSleepQuality()
                    && this.getEmail().equals(that.getEmail())
                    && this.getPassword().equals(that.getPassword())
                    && this.getFirstName().equals(that.getFirstName())
                    && this.getLastName().equals(that.getLastName());   
        }
        return equals;
    }

    @Override
    public int hashCode() {
        final int idHash = (id == null) ? 0 : id.hashCode();
        final int dobHash = (dob == null) ? 0 : dob.hashCode();
        final int ageHash = Double.valueOf(age).hashCode();
        final int sleepQualityHash = (sleepQuality == null) ? 0 : sleepQuality.hashCode();
        final int emailHash = (email == null) ? 0 : email.hashCode();
        final int firstNameHash = (firstName == null) ? 0 : firstName.hashCode();
        final int lastNameHash = (lastName == null) ? 0 : lastName.hashCode();


        return idHash + dobHash + ageHash + sleepQualityHash + emailHash
                + firstNameHash + lastNameHash;
    }

}
