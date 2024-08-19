package com.eugeneprogram.comment.dao;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface CommentMapper {

	//public List<Map<String, Object>> commentList() throws Exception;
	List<Map<String, Object>> commentList(int offset, int limit) throws Exception;
	List<Map<String, Object>> commentListLatest(int offset, int limit) throws Exception;
        List<Map<String, Object>> commentListOldest(int offset, int limit) throws Exception;
	public Map<String, Object> getCommentById(long cmtId) throws Exception;
	public void insertComment(Map<String, Object>cmt) throws Exception;
	public void updateComment(Map<String, Object>cmt) throws Exception;
	public void deleteComment(long cmtId) throws Exception;

	public List<Map<String, Object>> likeList() throws Exception;
	// 특정 댓글과 사용자에 대한 좋아요 조회
        public Map<String, Object> getLikeByCmtIdAndMbId(Map<String, Object> params) throws Exception;
	public void insertLike(Map<String, Object> like) throws Exception;
	public void deleteLike(Map<String, Object> like) throws Exception;
	public int countLikes(long cmtId) throws Exception;
	public int countTotalComments() throws Exception;
}
