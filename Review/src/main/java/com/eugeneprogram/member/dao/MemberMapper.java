package com.eugeneprogram.member.dao;

import java.util.List;
import java.util.Map;

public interface MemberMapper {
	public List<Map<String, Object>> getList() throws Exception;
	public Map<String, Object> getOnemb(long mbId) throws Exception;
	public void insertMember(Map<String, Object> mb) throws Exception;
	public void updateMember(Map<String, Object> mb) throws Exception;
	public void deleteMember(long id) throws Exception;
	public void updateFlagmb(Map<String,Object>mb) throws Exception;
	public void loginmb(Map<String,Object>mb) throws Exception;
}
