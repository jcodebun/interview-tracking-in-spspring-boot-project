package com.InterviewTracking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.InterviewTracking.dto.FeedbackDTO;


public interface FeedbackDAO extends JpaRepository<FeedbackDTO, Long> {

	public FeedbackDTO findById(long id);
	public FeedbackDTO findByInterviewId(long id);
	
}
