package com.eugeneprogram.category.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eugeneprogram.category.dao.CategoryMapper;

@Service
public class CategoryService {
	@Autowired
	CategoryMapper categoryMapper;
	
	public List<Map<String, Object>> getAll() throws Exception{
		return categoryMapper.getAllCategory();
		
	}
}
