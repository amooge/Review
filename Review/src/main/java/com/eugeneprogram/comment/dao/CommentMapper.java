package com.eugeneprogram.comment.dao;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface CommentMapper {

	List<Map<String, Object>> commentList(long pstId, int offset, int limit) throws Exception;
        List<Map<String, Object>> commentListLatest(long pstId, int offset, int limit) throws Exception;
        List<Map<String, Object>> commentListOldest(long pstId, int offset, int limit) throws Exception;
	public Map<String, Object> getCommentById(long cmtId) throws Exception;
	public void insertComment(Map<String, Object>cmt) throws Exception;
	public void updateComment(Map<String, Object>cmt) throws Exception;
	public void deleteComment(long cmtId) throws Exception;
	public void deleteLikesByCommentId(long cmtId);
	public List<Map<String, Object>> likeList() throws Exception;
        public Map<String, Object> getLikeByCmtIdAndMbId(Map<String, Object> params) throws Exception;
	public void insertLike(Map<String, Object> like) throws Exception;
	public void deleteLike(Map<String, Object> like) throws Exception;
	public void updateLikeCount(long cmtId) throws Exception;
	public int countLikes(long cmtId) throws Exception;
	public int countTotalComments(long pstId) throws Exception;	
	int getLikeCount(long cmtId) throws Exception;
	
}
