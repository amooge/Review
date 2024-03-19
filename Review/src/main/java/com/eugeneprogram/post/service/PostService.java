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
	
	public List<Map<String, Object>>  getList(String search) throws Exception {
		if(search == null) {
			search = "";
		}
		//return null;
		return postMapper.getList(search);
	}
	
	/*
	 * pstId 가 null인 경우 DB에 조회할 값이 없음 -> 수정이 아닌 추가!
	 * pstId가 값이 있는 경우 DB에 조회할 값이 있으므로 수정할 값을 가져옴! 
	 */
	public Map<String, Object> getForm(Long pstId)throws Exception{
		Map<String, Object> post = new HashMap<String, Object>();
		//Long 0 == null
		if(pstId.equals(null)) {
			post.put("title", "");
			post.put("text", "");
			
		}else {
		 post = postMapper.getOne(pstId);
		 
		}
		return post;
	}
	
	// Exception ?
	/*
	 * pstId가 null값이면 추가 
	 * pstId가 값이 있으면 수정
	 */
	public void addAndUpdate(Map<String, Object> pst) throws Exception{
		if(postMapper.getOne((long) pst.get("pstId")) == null || pst.get("pstId") == null) {
			postMapper.insertPost(pst);
		}else {
			postMapper.updatePost(pst);
		}
	}
	
	public void deletePost(long pstId) throws Exception{
		postMapper.deletePost(pstId);
	}
	
	
}
