package com.eugeneprogram.member.DAO;

import java.util.List;
import java.util.Map;

public interface MemberMapper {
	
	//회원 아이디를 이용하여 회원정보를 조회하는 메서드.
	
	//throws exception : 메서드나 생성자의 선언부에 추가되며, 해당 메서드나 생성자가 호출될 때 발생할 수 있는 예외를 명시적으로 나열

	public Map<String,Object> getOnemb(long id) throws Exception;
	
	//모든 회원정보를 조회하는 메서드 
	
	public List<Map<String,Object>> getList() throws Exception;
	
	//새로운 회원정보 추가하는 메서드 
	
	public void insertMember(Map<String, Object>mb) throws Exception;
	
	//회원정보를 업데이트 하는 메서드 
	
	public void updateMember(Map<String, Object>mb)throws Exception;
	
	//회원정보를 삭제하는 메서드 
	
	public void deleteMember(long mbId) throws Exception;
		
	
	
}
