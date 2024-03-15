package com.eugeneprogram.member.service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eugeneprogram.member.dao.MemberMapper;


@Service
public class MemberService {
	@Autowired
	MemberMapper memberMapper;
	
	public List<Map<String, Object>> getList() throws Exception{
		return memberMapper.getAllMembers();
	}
}
