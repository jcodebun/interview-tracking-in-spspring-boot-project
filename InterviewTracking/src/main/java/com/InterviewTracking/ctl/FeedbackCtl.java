package com.InterviewTracking.ctl;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.InterviewTracking.dto.FeedbackDTO;
import com.InterviewTracking.dto.ScheduleInterviewDTO;
import com.InterviewTracking.dto.UserDTO;
import com.InterviewTracking.exception.RecordNotFoundException;
import com.InterviewTracking.form.FeedbackForm;

import com.InterviewTracking.service.FeedbackService;
import com.InterviewTracking.service.ScheduleInterviewService;
import com.InterviewTracking.service.UserService;

@Controller
public class FeedbackCtl {
	
	
	@Autowired
	public FeedbackService service;

	@Autowired
	public UserService userService;
	
	
	@Autowired
	public ScheduleInterviewService scheduleInterviewService;
	
	
	@GetMapping("/feedback")
	public String feedback(@ModelAttribute("form")FeedbackForm form, Model model, @RequestParam("id") long id) {
       
		model.addAttribute("interviewId",id);
		return "feedbackview";
	}
	
	@PostMapping("/AddFeedback")
	public String Add(@Valid @ModelAttribute("form")FeedbackForm form,  BindingResult bindingResult, Model model) throws Exception {

		System.out.println("form: "+form);
		try {
		if (bindingResult.hasErrors()) {
			System.out.println("bindingResult : "+bindingResult);
			return "feedbackview";
		}else {
			FeedbackDTO bean = form.getDTO();
		    long interviewID = bean.getInterviewId();
		   ScheduleInterviewDTO scheduleInterviewDTO = scheduleInterviewService.findScheduleInterviewById(interviewID);
		    bean.setEmail(scheduleInterviewDTO.getEmail());
		    bean.setFeedbackBy(scheduleInterviewDTO.getScheduleWith());
			service.Add(bean);
			
			model.addAttribute("success", "Feedback Submit successfully");
			return "feedbackview";
		}}catch (RecordNotFoundException e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
			e.printStackTrace();
			return "feedbackview";
		}
	}
	
	@GetMapping("/FeedbackList")
	public String list(@ModelAttribute("form")FeedbackForm form, Model model, HttpSession session){
		List<FeedbackDTO>	list = service.list();
		model.addAttribute("list", list);
	return "feedbacklistview";
		
	}
	

	
	@GetMapping("/FeedbackEdit")	
	public String update(@ModelAttribute("form")FeedbackForm form, Model model, @RequestParam("id") long id ){
		FeedbackDTO bean = service.findFeedbackById(id);
		form.populate(bean);
		model.addAttribute("bean",bean);	
		return "feedbackviewlist";
	}
	
	@GetMapping("FeedbackDelete")	
	public String delete(@ModelAttribute("form")FeedbackForm form, Model model, @RequestParam("id") long id ) throws Exception{
		service.delete(id);	
		
		List<FeedbackDTO> list =	service.list();
		model.addAttribute("list", list);
		model.addAttribute("success", "Feedback Deleted successfully");
		return "feedbackviewlist";
	}
	

}
