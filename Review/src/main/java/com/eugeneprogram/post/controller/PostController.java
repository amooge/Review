package com.eugeneprogram.post.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


import com.eugeneprogram.post.service.PostService;

@Controller
public class PostController {
	@Autowired
	PostService postService;
	
	/*
	 * 개시물 목록을 보여주는 post.jsp 페이지로 이동
	 */
	@RequestMapping(value = "/post")
	public String goPost(Model model,
						 @RequestParam(name="search", required=false) String search,
						 @RequestParam(name="kind", defaultValue="0") int kind) throws Exception {
		
		model.addAttribute("list", postService.getList(search, kind));
		return "post";
	}
	
	/*
	 * 개시물(단일값)을 보여주는 post-detail.jsp 페이지로 이동
	 */
	@RequestMapping(value = "/post-detail")
	public String postDetail(Model model, @RequestParam("id") long id) throws Exception{
		model.addAttribute("post", postService.getForm(id));	
		return "post-detail";
	}
	
	/*
	 * 추가 수정할 값을 가져옴 
	 */
	@RequestMapping(value = "/post-form")
	public String postForm(Model model, @RequestParam(required = false, defaultValue = "0") Long id) throws Exception{
		model.addAttribute("post", postService.getForm(id));
		
		return "post-form";
	}
	
	/*
	 * form.jsp로부터 추가/수정 할 값들을 가져옴
	 * 가져온 값들을 DB컬럼에 맞게 이름과 값들을 Map에 담아둠
	 */
	@RequestMapping(value = "/post-add-update")
	public String postAddUpdate(@RequestParam(required = false, defaultValue = "0") long pstId,
							 @RequestParam("text") String text,
							 @RequestParam("title") String title,
							 @RequestParam("mbId") long mbId,
							 @RequestParam("ctgId") long ctgId) throws Exception{
		
		Map<String, Object> pst = new HashMap<String, Object>();
		pst.put("pstId", pstId);
		pst.put("pstTitle", title);
		pst.put("pstText", text);
		pst.put("mbId", mbId);
		pst.put("ctgId", ctgId);
		
		postService.addAndUpdate(pst);
		
		// /post url로 이동
		return "redirect:post";
	}
	
	/*
	 * postService겍체에서 deletePost를 호출하고 pstId값을 전달함 
	*/
	@RequestMapping("/post-delete")
	public String postDelete(@RequestParam("id") long pstId) throws Exception{
		postService.deletePost(pstId);
		return "redirect:post";
	}
	
}