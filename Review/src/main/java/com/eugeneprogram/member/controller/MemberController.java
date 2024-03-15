package com.eugeneprogram.member.controller;

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
	
	@RequestMapping(value = "member")
	public String MemberList(Model model) throws Exception{
		model.addAttribute("mbList", memberService.getList());
		return "member";
	}
	
}
