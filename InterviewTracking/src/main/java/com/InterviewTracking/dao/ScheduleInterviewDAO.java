package com.InterviewTracking.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.InterviewTracking.dto.ScheduleInterviewDTO;


public interface ScheduleInterviewDAO extends JpaRepository<ScheduleInterviewDTO, Long> {


	public ScheduleInterviewDTO findByEmail(String email);
	public ScheduleInterviewDTO findById(long id);
	public List<ScheduleInterviewDTO> findByScheduleWithId(long id);
}
