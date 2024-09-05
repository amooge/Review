package com.eugeneprogram.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;


import com.eugeneprogram.comment.dao.CommentMapper;
import com.eugeneprogram.comment.service.CommentService;
@Controller
public class CommentController {

	@Autowired
	CommentService commentService;
	@Autowired
    CommentMapper commentMapper;
	
	//댓글 목록 보여주는 comment.jsp
	/*
	@RequestMapping(value = "comment")
	public String commentList(Model model, @RequestParam(required = false, defaultValue = "latest") String sort,
            @RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		int pageSize = 2; // 한 페이지에 보여질 댓글 수
		int totalCount = commentService.countTotalComments(); // 전체 댓글 수
		// 전체 페이지 수 계산
		int totalPages = (int) Math.ceil((double) totalCount / pageSize);

		// 페이지 번호 유효성 검사
		if (page < 1) {
			page = 1;
			} else if (page > totalPages) {
				page = totalPages;
				}

		// 특정 페이지의 댓글 목록 가져오기
		int offset = (page - 1) * pageSize;
		model.addAttribute("commentList", commentService.commentList(sort, offset, pageSize));
		model.addAttribute("currentSort", sort);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", totalPages);

		return "comment";}//댓글 목록을 가져와 모델에 추가 jsp에서 반복문을 통해 댓글 표시
	*/ //이부분 postController.java에 합침
	//댓글을 보여주는 comment-detail.jsp로 이동
	@RequestMapping(value = "/comment-detail")
	public String commentDetail(Model model, @RequestParam(required = false, defaultValue = "0") Long id) throws Exception{
		model.addAttribute("comment", commentService.getComment(id, null));	
		return "comment-detail";
	}//특정 댓글을 가져와 모델에 추가함 jsp에서 댓글의세부 정보를 표시할 수 있다
	@RequestMapping(value = "/comment-form")
	public String commentForm(Model model, @RequestParam(required = false, defaultValue = "0") Long id,
										   @RequestParam(name="pstId", required = false) Long pstId) throws Exception{
		model.addAttribute("comment", commentService.getComment(id, pstId));		
		model.addAttribute("like", commentService.getComment(id, pstId));
		return "comment-form";
	}
	//댓글 작성,수정
	@RequestMapping(value = "/comment-update")
	public String commentAddUpdate(@RequestParam(value ="cmtId", required = false, defaultValue = "0") long cmtId,
							 @RequestParam("cmtText") String cmtText,
							 @RequestParam("pstId") long pstId,
							 @RequestParam("mbId") long mbId) throws Exception{

		Map<String, Object> cmt = new HashMap<String, Object>();
		cmt.put("cmtId", cmtId);
		cmt.put("cmtText", cmtText);
		cmt.put("mbId", mbId);
		cmt.put("pstId", pstId);
		System.out.println("pstId: " + pstId); 
		commentService.addAndUpdate(cmt);
		
		return "redirect:/post-detail?id=" + pstId;
	}	
	
	@RequestMapping(value = "/comment-add")
	public String commentAdd(@RequestParam(value ="cmtId", required = false, defaultValue = "0") long cmtId,
							 @RequestParam("cmtText") String cmtText,
							 @RequestParam("pstId") long pstId,
							 @RequestParam("mbId") long mbId) throws Exception{

		Map<String, Object> cmt = new HashMap<String, Object>();
		cmt.put("cmtId", cmtId);
		cmt.put("cmtText", cmtText);
		cmt.put("mbId", mbId);
		cmt.put("pstId", pstId);
		System.out.println("pstId: " + pstId); 
		commentService.addAndUpdate(cmt);
		
		return "redirect:/post-detail?id=" + pstId;
	}	
	
	//댓글 삭제
	@RequestMapping("/comment-delete")
	public String deleteComment(@RequestParam("id") long cmtId, 
	                             @RequestParam(value = "pstId", required = false) Long pstId) throws Exception {
	    commentService.deleteComment(cmtId);
	    
	    // pstId가 null이면 기본값으로 처리하거나 오류 페이지로 리다이렉트할 수 있습니다.
	    if (pstId == null) {
	        return "redirect:/post";
	    }//삭제하면 무조건 pstId가 null로 가기에 그냥 post로 가도록 해주었음
	    //삭제하면 무조건 오류페이지로 리다이렉트 되는 오류, 그냥 post페이지로 가도록 함
	    return "redirect:/post";
	}


	// 댓글 추천 기능
	 @RequestMapping(value = "/like-toggle", method = RequestMethod.POST)
	    @ResponseBody
	    public Map<String, Object> toggleLike(@RequestParam("cmtId") long cmtId,
	                                           @RequestParam("mbId") long mbId) throws Exception {
	        commentService.toggleLike(cmtId, mbId);

	        Map<String, Object> response = new HashMap<>();
	        response.put("isLiked", commentService.isLiked(cmtId, mbId));
	        response.put("likeCount", commentMapper.countLikes(cmtId)); // 현재 좋아요 수 조회
	        return response;
	    }
}
	
