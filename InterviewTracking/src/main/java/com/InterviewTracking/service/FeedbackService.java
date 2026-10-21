package com.InterviewTracking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.InterviewTracking.dao.FeedbackDAO;
import com.InterviewTracking.dto.FeedbackDTO;
import com.InterviewTracking.exception.RecordNotFoundException;


@Service
public class FeedbackService {


	@Autowired
	public FeedbackDAO dao;

	public FeedbackDTO Add(FeedbackDTO dto) throws Exception {
	
		FeedbackDTO feedback = dao.findByInterviewId(dto.getInterviewId());
		FeedbackDTO feedbackDto = null;
		if(feedback == null) {
			feedbackDto =	dao.save(dto);
		}else {
			throw new RecordNotFoundException("Feedback is alredy submited");
		}
		
       return  feedbackDto;
	}
	
	
	public List<FeedbackDTO> list(){
		List<FeedbackDTO> dto = dao.findAll();
		return dto;
	}

	public FeedbackDTO findFeedbackById(long id) {
		return dao.findById(id);
	}
	

	
	public FeedbackDTO update(FeedbackDTO dto){
		FeedbackDTO bean = dao.saveAndFlush(dto);
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
