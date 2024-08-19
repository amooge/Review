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

		return "comment";
	}
	//댓글을 보여주는 comment-detail.jsp로 이동, 반복문을 통해 댓글 표시
	
	@RequestMapping(value = "/comment-detail")
	public String commentDetail(Model model, @RequestParam(required = false, defaultValue = "0") Long id) throws Exception{
		model.addAttribute("comment", commentService.getComment(id, null));	
		return "comment-detail";
	}//특정 댓글을 가져와 모델에 추가함 jsp에서 댓글의 세부 정보를 표시
	
	
	@RequestMapping(value = "/comment-form")
	public String commentForm(Model model, @RequestParam(required = false, defaultValue = "0") Long id,
										   @RequestParam(name="pstId", required = false) Long pstId) throws Exception{
		model.addAttribute("comment", commentService.getComment(id, pstId));		
		model.addAttribute("like", commentService.getComment(id, pstId));
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
		
		return "redirect:post";
	}	
	
	//댓글 삭제
	@RequestMapping("/comment-delete")
    public String deleteComment(@RequestParam("id") long cmtId) throws Exception{
		commentService.deleteComment(cmtId);
        return "redirect:post";
    }
	// 댓글 추천 기능
	 @PostMapping(value = "/like-toggle")
	    @ResponseBody
	    public Map<String, Object> toggleLike(@RequestParam long cmtId, @RequestParam long mbId) throws Exception {
	        boolean isLiked = commentService.toggleLike(cmtId, mbId);
	        int likeCount = commentService.countLikes(cmtId);

	        Map<String, Object> response = new HashMap<>();
	        response.put("isLiked", isLiked);
	        response.put("likeCount", likeCount);

	        return response;
	    }
}
