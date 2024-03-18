package com.eugeneprogram.member.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;



import com.eugeneprogram.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	//"/member-list" 경로에 대한 GET 요청 처리하는 메서드.	
	@RequestMapping(value = "/member")
	public String goMember(Model model) throws Exception {
		//memberService를 사용하여 회원목록을 가져와 목록을 추가함.
		model.addAttribute("mblist", memberService.getList());
		return "member";
	}
	
	//"/member-form" 경로에 대한 GET 요청 처리하는 메서드.	
	@RequestMapping(value = "/member-form")
	public String memberForm(Model model, @RequestParam(required = false, defaultValue = "0") Long id) throws Exception{
		//memberService를 사용하여 특정 회원의 정보를 가져와 모델에 추가함.
		model.addAttribute("member", memberService.getForm(id));
		return "member-form";
	}
	
	
	@RequestMapping(value = "/member-detail")
	public String memberDetail(Model model, @RequestParam(required = false, defaultValue="0") Long id) throws Exception{
	model.addAttribute("member", memberService.getForm(id));	
	return "member-detail";
	}
	
	@RequestMapping(value = "/member-add-update")
	public String memberAddUpdate(@RequestParam(required = false, defaultValue = "0")long mbId,
								@RequestParam(required = false, defaultValue = "0")String mbName,
								@RequestParam(required = false, defaultValue = "0")String mbPw,
								@RequestParam(required = false, defaultValue = "0")String mbNickname,
								@RequestParam(required = false, defaultValue = "0")String mbMail,
								@RequestParam(required = false, defaultValue = "0")String mbPhone,
								@RequestParam(required = false, defaultValue = "0")String mbBirth)throws Exception{
								 
			
			Map<String, Object> mb = new HashMap<String, Object>();
			mb.put("mbId", mbId);
			mb.put("mbName", mbName);
			mb.put("mbPw", mbPw);
			mb.put("mbNickname", mbNickname);
			mb.put("mbMail", mbMail);
			mb.put("mbPhone", mbPhone);
			mb.put("mbBirth", mbBirth);
	
			
			
		    
			memberService.addAndUpdate(mb);
			
			
			return "redirect:member";
	}
	@RequestMapping("/member-delete")
	public String memberDelete(@RequestParam("id") long mbId) throws Exception{
		memberService.deleteMember(mbId);
		return "redirect:member";
	}

	
	
	
}
