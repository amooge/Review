package com.eugeneprogram.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eugeneprogram.member.dao.MemberMapper;

@Service
public class MemberService {
	@Autowired
	MemberMapper memberMapper;
	
	
	public List<Map<String, Object>> getList() throws Exception {
		return memberMapper.getList();
	}
	
	public Map<String, Object> getForm(Long mbId)throws Exception{
		Map<String, Object> member = new HashMap<String, Object>();
		if(mbId.equals(null)) {
			member.put("ID","");			
		}
		else {
			member =  memberMapper.getOnemb(mbId);
		}
		
		return member ;
	}
	
	public void addAndUpdate(Map<String, Object> mb) throws Exception{
		if(memberMapper.getOnemb((long)mb.get("mbId")) == null || mb.get("mbId") == null) {
			memberMapper.insertMember(mb);
		}else {
			memberMapper.updateMember(mb);
		}
		
	}
	
	public void deleteMember(long mbId)throws Exception{
	memberMapper.deleteMember(mbId);
	}
	
	public void Login(Map<String, Object> mb) throws Exception{
		if(memberMapper.getOnemb((long)mb.get("mbId")) == null || mb.get("mbId") == null) {
			memberMapper.loginmb(mb);
		}
		
		
	}
	

}
