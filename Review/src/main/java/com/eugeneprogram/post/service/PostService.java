package com.eugeneprogram.post.service;

// test git push...

import java.util.List;
import java.util.Map;
import java.util.HashMap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eugeneprogram.post.dao.PostMapper;

@Service
public class PostService {
	@Autowired
	PostMapper postMapper;
	
	public List<Map<String, Object>>  getList() throws Exception {
		return postMapper.getList();
	}
	
	public Map<String, Object> getForm(long id)throws Exception{
		Long pstId = id;
		Map<String, Object> post = new HashMap<String, Object>();
		if(pstId.equals(null)) {
			post.put("title", "");
			post.put("text", "");
			
		}else {
		 post = postMapper.getOne(id);
		 
		}
		return post;
	}
	
	// Exception ?
	public void addAndUpdate(Map<String, Object> pst) throws Exception{
		if(postMapper.getOne((long) pst.get("pstId")) == null || pst.get("pstId") == null) {
			postMapper.insertPost(pst);
		}else {
			postMapper.updatePost(pst, (long)pst.get("pstId"));
		}
	}
	
	
}
