package com.InterviewTracking.form;

import javax.validation.constraints.NotEmpty;

import com.InterviewTracking.dto.BaseDTO;
import com.InterviewTracking.dto.FeedbackDTO;
import com.InterviewTracking.utility.DataUtility;

import lombok.Getter;
import lombok.Setter;


public class FeedbackForm extends BaseDTO {

	
	private String interviewId;

	@NotEmpty(message = "Feedback is required")
	private String feedback;
	
	
	
	
	
	public String getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(String interviewId) {
		this.interviewId = interviewId;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public FeedbackDTO getDTO() {
		FeedbackDTO bean=new FeedbackDTO();
		bean.setId(id);
		bean.setInterviewId(DataUtility.getLong(interviewId));
		bean.setFeedback(feedback);
	
		return bean;
	}

	public void populate(FeedbackDTO bean) {
		id = bean.getId();
		interviewId = DataUtility.getStringData(bean.getInterviewId());
		feedback = bean.getFeedback();
	

	}

	
}
