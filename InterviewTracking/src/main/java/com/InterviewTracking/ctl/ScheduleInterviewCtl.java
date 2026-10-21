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

import com.InterviewTracking.dto.ScheduleInterviewDTO;
import com.InterviewTracking.dto.UserDTO;
import com.InterviewTracking.exception.RecordNotFoundException;
import com.InterviewTracking.form.ScheduleInterviewForm;

import com.InterviewTracking.service.ScheduleInterviewService;
import com.InterviewTracking.service.UserService;

@Controller
public class ScheduleInterviewCtl {

	@Autowired
	public ScheduleInterviewService service;

	@Autowired
	public UserService userService;
	
	
	@GetMapping("/ScheduleInterview")
	public String ScheduleInterview(@ModelAttribute("form")ScheduleInterviewForm form, Model model, @RequestParam("id") long id, @RequestParam("interviewType") String interviewType) {
         System.out.println("ID: "+id+ "interviewType: "+interviewType);
		UserDTO userDTO = userService.findUserById(id);
		List<UserDTO> userTypeList = userService.UserListByRole(interviewType);
		for (UserDTO userDTO2 : userTypeList) {
			System.out.println("userDTO2: "+userDTO2);
		}
		model.addAttribute("userDTO",userDTO);
		model.addAttribute("userTypeList",userTypeList);
		return "scheduleinterview";
	}
	
	@PostMapping("/AddScheduleInterview")
	public String Add(@Valid @ModelAttribute("form")ScheduleInterviewForm form,  BindingResult bindingResult, Model model) {

		System.out.println("form: "+form);
		try {
		if (bindingResult.hasErrors()) {
			System.out.println("bindingResult : "+bindingResult);
			return "scheduleinterview";
		}else {
			ScheduleInterviewDTO bean = form.getDTO();
			
			long scheduleWithId = bean.getScheduleWithId();
			
			System.out.println("scheduleWithId: "+scheduleWithId);
			
			UserDTO udto =	userService.findUserById(scheduleWithId);
			
			System.out.println("udto: "+udto);
			
			bean.setScheduleWith(udto.getFirstName());
			
			service.Add(bean);
			
			model.addAttribute("success", "Interview Schedule successfully");
			return "scheduleinterview";
		}}catch (RecordNotFoundException e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
			e.printStackTrace();
			return "scheduleinterview";
		}
	}
	
	@GetMapping("/scheduleinterviewList")
	public String list(@ModelAttribute("form")ScheduleInterviewForm form, Model model, HttpSession session){
		List<ScheduleInterviewDTO> list = null;
		UserDTO user = (UserDTO)session.getAttribute("user");
		if(user.getUserRole().equals("Admin")) {
			list = service.list();
		}else {
			list = service.list(user.getId());
		}
	model.addAttribute("user", user);
	model.addAttribute("list", list);
	return "scheduleinterviewlist";
		
	}
	

	
	@GetMapping("/scheduleinterviewEdit")	
	public String update(@ModelAttribute("form")ScheduleInterviewForm form, Model model, @RequestParam("id") long id ){
		ScheduleInterviewDTO bean = service.findScheduleInterviewById(id);
		form.populate(bean);
		model.addAttribute("bean",bean);	
		return "scheduleinterview";
	}
	
	@GetMapping("scheduleinterviewDelete")	
	public String delete(@ModelAttribute("form")ScheduleInterviewForm form, Model model, @RequestParam("id") long id ) throws Exception{
		service.delete(id);	
		
		List<ScheduleInterviewDTO> list =	service.list();
		model.addAttribute("list", list);
		model.addAttribute("success", "scheduled interview Deleted successfully");
		return "scheduleinterviewlist";
	}
	
	
}
