package com.eugeneprogram.post.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface PostMapper {
	public List<Map<String, Object>> getList(String search) throws Exception;
	public Map<String, Object> getOne(long id) throws Exception;
	public void insertPost(Map<String, Object> pst) throws Exception;
	public void updatePost(Map<String, Object> pst) throws Exception;
	public void deletePost(long id) throws Exception;
}