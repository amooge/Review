package com.eugeneprogram.post.service;

// test git push...

import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired; //  
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.eugeneprogram.data.RequestList;
import com.eugeneprogram.post.dao.PostMapper;


@Service
public class PostService {
	@Autowired
	PostMapper postMapper;
	
	public Page<Map<String, Object>>  getList(String search, int kind, Pageable pageable) throws Exception {
		Map<String, Object> searchList = new HashMap<String, Object>();
		Map<String, Object> post = new HashMap<String, Object>();
		if(search == null) {
			searchList.put("search", "");
			//search = "";
		}else {
			searchList.put("search", search);
		}
		
		
		RequestList<?> requestList = RequestList.builder()
				.data(post)
				.pageable(pageable)
				.build();
		
		  List<Map<String, Object>> content = postMapper.getListPage(requestList);
		  int total = postMapper.getListPostCount(post);
		  
		 
		//searchList.put("kind", kind);
		
		//return postMapper.getList(searchList);
		return new PageImpl<>(content, pageable, total);
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
			pst.put("pstCreateDate", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			
			postMapper.insertPost(pst);
		}else {
			pst.put("pstUpdateDate", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			postMapper.updatePost(pst);
		}
	}
	
	public void deletePost(long pstId) throws Exception{
		postMapper.deletePost(pstId);
	}
	
	
}