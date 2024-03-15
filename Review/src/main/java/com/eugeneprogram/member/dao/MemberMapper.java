package com.eugeneprogram.member.dao;

import java.util.List;
import java.util.Map;

public interface MemberMapper {
	public List<Map<String, Object>> getAllMembers() throws Exception;
}
