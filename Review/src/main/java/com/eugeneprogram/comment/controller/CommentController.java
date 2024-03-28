package com.eugeneprogram.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
//import org.springframework.stereotype.Controller;

import com.eugeneprogram.comment.service.CommentService;

@Controller
public class CommentController {

	@Autowired
	CommentService commentService;
	
	//댓글 목록 보여주는 comment.jsp
	
	@RequestMapping(value = "comment")
	public String commentList(Model model) throws Exception {
		model.addAttribute("commentList", commentService.commentList());
		return "comment";
	}
	//댓글을 보여주는 comment-detail.jsp로 이동
	@RequestMapping(value = "/comment-detail")
	public String commentDetail(Model model, @RequestParam(required = false, defaultValue = "0") Long id) throws Exception{
		model.addAttribute("comment", commentService.getComment(id));	
		return "comment-detail";
	}//?????????????
	@RequestMapping(value = "/comment-form")
	public String commentForm(Model model, @RequestParam(required = false, defaultValue = "0") Long id) throws Exception{
		model.addAttribute("comment", commentService.getComment(id));		
		return "comment-form";
	}
	//댓글 작성
	@RequestMapping(value = "/comment-add-update")
	public String commentAddUpdate(@RequestParam(required = false, defaultValue = "0") long cmtId,
							 @RequestParam("cmtText") String cmtText,
							 @RequestParam("mbId") long mbId,
							 @RequestParam("pstId") long pstId) throws Exception{
		
		Map<String, Object> cmt = new HashMap<String, Object>();
		cmt.put("cmtId", cmtId);
		cmt.put("cmtText", cmtText);
		cmt.put("mbId", mbId);
		cmt.put("pstId", pstId);
		//cmt.put("cmtParent", cmtParent);
		
		commentService.addAndUpdate(cmt);
		
		return "redirect:comment";
	}	
	
	//댓글 삭제
	@RequestMapping("/comment-delete")
    public String deleteComment(@RequestParam("id") long cmtId) throws Exception{
		commentService.deleteComment(cmtId);
        return "redirect:comment";
    }
}
