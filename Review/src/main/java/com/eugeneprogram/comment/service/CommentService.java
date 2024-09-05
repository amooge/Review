package com.eugeneprogram.comment.service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eugeneprogram.comment.dao.CommentMapper;


@Service
public class CommentService {

	@Autowired
    CommentMapper commentMapper;

	
	/*
    public List<Map<String, Object>> commentList() throws Exception {
        List<Map<String, Object>> comments = commentMapper.commentList();
        for (Map<String, Object> comment : comments) {
            long cmtId = (long) comment.get("cmtId");
            int likeCount = commentMapper.countLikes(cmtId);
            comment.put("likeCount", likeCount);
        }
        return comments;
    }*/

	public int countTotalComments(long pstId) throws Exception {
        return commentMapper.countTotalComments(pstId);
    }
	
	public List<Map<String, Object>> getComments(long pstId, String sort, int offset, int limit) throws Exception {
	    if ("oldest".equals(sort)) {
	        return commentMapper.commentListOldest(pstId, offset, limit);
	    } else {
	        return commentMapper.commentListLatest(pstId, offset, limit);
	    }
	    
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
	}//특정 댓글을 반환 map을 사용해 댓글의 다양한 속성을 한번에 반환
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
    public void deleteComment(long cmtId) throws Exception {
        // 댓글과 관련된 좋아요 먼저 삭제
        commentMapper.deleteLikesByCommentId(cmtId);
        // 댓글 삭제
        commentMapper.deleteComment(cmtId);
    }
    //추천
 // 좋아요 관련 메서드
public List<Map<String, Object>> likeList() throws Exception {
        
    	return commentMapper.likeList();
    }
//좋아요 토글 메서드
public void toggleLike(long cmtId, long mbId) throws Exception {
    Map<String, Object> Params = new HashMap<>();
    Params.put("cmtId", cmtId);
    Params.put("mbId", mbId);

    Map<String, Object> existlike = commentMapper.getLikeByCmtIdAndMbId(Params);
    
    if (existlike == null) {
        commentMapper.insertLike(Params);
        
    } else {
        commentMapper.deleteLike(Params);
        
    }
    //좋아요 수 업데이트
    commentMapper.updateLikeCount(cmtId);
}

// 댓글의 좋아요 상태 확인
public boolean isLiked(long cmtId, long mbId) throws Exception {
    Map<String, Object> params = new HashMap<>();
    params.put("cmtId", cmtId);
    params.put("mbId", mbId);
    return commentMapper.getLikeByCmtIdAndMbId(params) != null;
}

// 추가된 좋아요 수 조회 메서드
public long countLikes(long cmtId) throws Exception {
	 Map<String, Object> comment = commentMapper.getCommentById(cmtId);
	    return (Integer) comment.get("likeCount");
}

}
  
