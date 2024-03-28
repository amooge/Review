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

    public List<Map<String, Object>> commentList() throws Exception {
        
    	return commentMapper.commentList();
    }

    public Map<String, Object> getComment(Long cmtId)throws Exception{
		Map<String, Object> comment = new HashMap<String, Object>();
		//Long 0 == null
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
}
