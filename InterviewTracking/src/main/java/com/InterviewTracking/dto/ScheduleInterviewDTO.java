package com.InterviewTracking.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="scheduleinterview")
public class ScheduleInterviewDTO extends BaseDTO {
	
	@Column(name = "userid", length = 755)
	private String userid;
	
	@Column(name = "firstName", length = 755)
	private String firstName;

	@Column(name = "lastName", length = 755)
	private String lastName;
	
	@Column(name = "email", length = 755)
	private String email;
	
	@Column(name = "phoneNumber", length = 755)
	private String phoneNumber;
	
	@Column(name = "scheduleWithId")
	private long scheduleWithId;
	
	@Column(name = "scheduleWith", length = 755)
	private String scheduleWith;
	
	@Column(name = "date", length = 755)
	private String date;
	
	@Column(name = "time", length = 755)
	private String time;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public long getScheduleWithId() {
		return scheduleWithId;
	}

	public void setScheduleWithId(long scheduleWithId) {
		this.scheduleWithId = scheduleWithId;
	}

	public String getScheduleWith() {
		return scheduleWith;
	}

	public void setScheduleWith(String scheduleWith) {
		this.scheduleWith = scheduleWith;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
	
	
	
}
