package com.InterviewTracking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InterviewTracking.dao.ScheduleInterviewDAO;
import com.InterviewTracking.dao.UserDAO;
import com.InterviewTracking.dto.ScheduleInterviewDTO;
import com.InterviewTracking.dto.UserDTO;
import com.InterviewTracking.exception.RecordNotFoundException;

@Service
public class ScheduleInterviewService {
	
	@Autowired
	public ScheduleInterviewDAO dao;
	
	
	
	public ScheduleInterviewDTO Add(ScheduleInterviewDTO dto) {
	ScheduleInterviewDTO user = null;
	//user = dao.findByEmail(dto.getEmail());
	//System.out.println("ScheduleInterviewDTO by email........: "+user);
	//if(user != null)
	//	throw new RecordNotFoundException("Inteview is already scheduled....");
	  //  System.out.println("dto Before Save: "+dto);
	    user = dao.save(dto);
       return  user;
	}
	

	
	public ScheduleInterviewDTO findScheduleInterviewById(long id) {
		return dao.findById(id);
	}
	

	
	public List<ScheduleInterviewDTO> list(){
		List<ScheduleInterviewDTO> dto = dao.findAll();
		return dto;
	}

	public List<ScheduleInterviewDTO> list(long id){
		List<ScheduleInterviewDTO> dto = dao.findByScheduleWithId(id);
		return dto;
	}
	

	
	public ScheduleInterviewDTO update(ScheduleInterviewDTO dto){
		ScheduleInterviewDTO bean = dao.saveAndFlush(dto);
		return bean;
	}
	
	public void delete(long id) throws Exception {
		if(id>0)
		{
			dao.deleteById(id);
		}else {
			throw new Exception("Not a valid id");
		}
		
	}

}
