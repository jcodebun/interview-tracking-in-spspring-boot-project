package com.InterviewTracking.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="feedback")
public class FeedbackDTO extends BaseDTO {

	@Column(name = "interviewId")
	private long interviewId;
	
	@Column(name = "feedback", length = 755)
	private String feedback;
	
	@Column(name = "email", length = 755)
	private String email;
	
	@Column(name = "feedbackBy", length = 755)
	private String feedbackBy;

	public long getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(long interviewId) {
		this.interviewId = interviewId;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFeedbackBy() {
		return feedbackBy;
	}

	public void setFeedbackBy(String feedbackBy) {
		this.feedbackBy = feedbackBy;
	}
	
	
	
	

}
