package com.eugeneprogram.post.service;

// test git push...

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eugeneprogram.post.DAO.PostMapper;

@Service
public class PostService {
	@Autowired
	PostMapper postMapper;
	
	public List<Map<String, Object>>  getList() throws Exception {
		return postMapper.getList();
	}
	
	public Map<String, Object> getForm(long id)throws Exception{
		return postMapper.getOne(id);
	}
	
}
