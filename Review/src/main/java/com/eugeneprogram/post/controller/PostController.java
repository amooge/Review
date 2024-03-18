package com.eugeneprogram.post.controller;


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
	
	@RequestMapping(value = "/post-form")
	public String postForm(Model model, @RequestParam("id") long id) throws Exception{
		model.addAttribute("post", postService.getForm(id));
		return "post-form";
	}
	
	
}
