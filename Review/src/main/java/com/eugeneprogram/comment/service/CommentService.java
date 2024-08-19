package com.eugeneprogram.comment.service;

import java.util.List;
import java.util.Map;
//import java.time.LocalDateTime;
//import java.time.LocalDateTime;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eugeneprogram.comment.dao.CommentMapper;

@Service
public class CommentService {

	@Autowired
    CommentMapper commentMapper;

    public List<Map<String, Object>> commentList(String sort, int offset, int limit) throws Exception {
        if ("oldest".equals(sort)) {
            return commentMapper.commentListOldest(offset, limit);
        } else {
            return commentMapper.commentListLatest(offset, limit);
        }
    }//모든 댓글 목록을 반환 list를 사용해 순서대로 댓글을 처리
    public int countTotalComments() throws Exception {
        return commentMapper.countTotalComments();
    }
    public Map<String, Object> getComment(Long cmtId, Long pstId)throws Exception{
		Map<String, Object> comment = new HashMap<String, Object>();
		//Long 0 == null
		
		if(pstId != null) {
			comment.put("pstId", pstId);
		}
		
		if(cmtId.equals(null)) {
			comment.put("text", "");
			
		}else {
			comment = commentMapper.getCommentById(cmtId);
		 
		}
		
		return comment;
	}
    //추가 업데이트
    public void addAndUpdate(Map<String, Object> cmt) throws Exception{
		if(commentMapper.getCommentById((long) cmt.get("cmtId")) == null || cmt.get("cmtId") == null) {
			//cmt.put("cmtCreateDate", LocalDateTime.now());
			commentMapper.insertComment(cmt);
		}else {
			//cmt.put("pstUpdateDate", LocalDateTime.now());
			commentMapper.updateComment(cmt);
		}
	}  
    //삭제
    public void deleteComment(long cmtId) throws Exception{
		commentMapper.deleteComment(cmtId);
	}
	// 좋아요 관련 메서드
     public List<Map<String, Object>> likeList() throws Exception {   
	     return commentMapper.likeList();
        }
//좋아요 토글 메서드
	public boolean toggleLike(long cmtId, long mbId) throws Exception {
		Map<String, Object> likeParams = new HashMap<>();
		likeParams.put("cmtId", cmtId);
		likeParams.put("mbId", mbId);

		Map<String, Object> existingLike = commentMapper.getLikeByCmtIdAndMbId(likeParams);

		if (existingLike == null) {
			commentMapper.insertLike(likeParams);
			return true; // 좋아요 추가됨
		} else {
			commentMapper.deleteLike(likeParams);
			return false; // 좋아요 취소됨
		}
	}
	// 추가된 좋아요 수 조회 메서드
	public int countLikes(long cmtId) throws Exception {
		return commentMapper.countLikes(cmtId);
	}

}
