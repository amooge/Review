package com.eugeneprogram.comment.dao;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface CommentMapper {

	public List<Map<String, Object>> commentList() throws Exception;
	public Map<String, Object> getCommentById(long cmtId) throws Exception;
	public void insertComment(Map<String, Object>cmt) throws Exception;
	public void updateComment(Map<String, Object>cmt) throws Exception;
	public void deleteComment(long cmtId) throws Exception;
}
