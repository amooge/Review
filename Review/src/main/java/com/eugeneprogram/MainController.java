package com.eugeneprogram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eugeneprogram.category.service.CategoryService;

@Controller
public class MainController {
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/")
	public String goMain(Model model) {
		return "main";
	}
}
