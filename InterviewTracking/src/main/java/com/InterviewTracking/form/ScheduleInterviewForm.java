package com.InterviewTracking.form;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import com.InterviewTracking.dto.BaseDTO;
import com.InterviewTracking.dto.ScheduleInterviewDTO;
import com.InterviewTracking.dto.UserDTO;
import com.InterviewTracking.utility.DataUtility;

import lombok.Getter;
import lombok.Setter;

public class ScheduleInterviewForm extends BaseDTO{

	@NotEmpty(message = "First name is required")
	private String userid;
	
	@NotEmpty(message = "First name is required")
	private String firstName;

	@NotEmpty(message = "Last name is required")
	private String lastName;
	
	@NotEmpty(message = "Last name is required")
	private String email;
	
	@NotEmpty(message = "Last name is required")
	private String phoneNumber;
	
	@NotEmpty(message = "Schedule With is required")
	private String scheduleWithId;
	
	@NotEmpty(message = "Date is required")
	private String date;
	
	@NotEmpty(message = "Time is required")
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

	public String getScheduleWithId() {
		return scheduleWithId;
	}

	public void setScheduleWithId(String scheduleWithId) {
		this.scheduleWithId = scheduleWithId;
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

	public ScheduleInterviewDTO getDTO() {
		ScheduleInterviewDTO bean=new ScheduleInterviewDTO();
		bean.setId(id);
		bean.setUserid(userid);
		bean.setFirstName(firstName);
		bean.setLastName(lastName);
		bean.setEmail(email);
		bean.setPhoneNumber(phoneNumber);
        bean.setScheduleWithId(DataUtility.getLong(scheduleWithId));
        bean.setDate(date);
        bean.setTime(time);
		return bean;
	}

	public void populate(ScheduleInterviewDTO bean) {
		id = bean.getId();
		userid = bean.getUserid();
		firstName=bean.getFirstName();
		lastName=bean.getLastName();
		email = bean.getEmail();
		phoneNumber = bean.getPhoneNumber();
		scheduleWithId = DataUtility.getStringData(bean.getScheduleWithId());
		date = bean.getDate();
		time = bean.getTime();

	}
}
