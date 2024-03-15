package com.eugeneprogram.post.controller;
// test commit


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


import com.eugeneprogram.post.service.PostService;

@Controller
public class PostController {
	@Autowired
	PostService postService;
	
	@RequestMapping(value = "/")
	public String goMain(Model model) throws Exception {
		model.addAttribute("list", postService.getList());
		return "main";
	}
	@RequestMapping(value = "/post-detail")
	public String postDetail(Model model, @RequestParam("id") long id) throws Exception{
		model.addAttribute("post", postService.getForm(id));	
		return "post-detail";
	}
	
	
	//;
	@RequestMapping(value = "/post-form")
	public String postForm(Model model, @RequestParam("id") long id) throws Exception{
		model.addAttribute("post", postService.getForm(id));
		return "post-form";
	}
	
	
	@RequestMapping(value = "/post-add-update")
	public String postAddUpdate(@RequestParam("id") long pstId,
							 @RequestParam("text") String text,
							 @RequestParam("title") String title,
							 @RequestParam("mbId") long mbId,
							 @RequestParam("ctgId") long ctgId) throws Exception{
		
		Map<String, Object> pst = new HashMap<String, Object>();
		pst.put("pstId", pstId);
		pst.put("pstTitle", title);
		pst.put("pstText", text);
		pst.put("mbId", mbId);
		pst.put("ctgId", ctgId);
		
		postService.addAndUpdate(pst);
		
		return "/";
	}
	/*
	*/
	
}
