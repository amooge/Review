package com.eugeneprogram.post.DAO;

import java.util.List;
import java.util.Map;


public interface PostMapper {
	public List<Map<String, Object>> getList() throws Exception;
	public Map<String, Object> getOne(long id) throws Exception; 
}
