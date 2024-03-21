<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member detail</title>
</head>
  <body>

    <h1>멤버 정보</h1>
    <table>
        
          <tr class="mycolor2">
            <td width="10%">아이디</td>
            <td width="10%">이름</td>
            <td width="10%">암호</td>
            <td width="10%">닉네임</td>
            <td width="15%">메일</td>
            <td width="15%">번호</td>
            <td width="15%">생일</td>
            <td width="5%">탈퇴</td>
            <td width="5%">어드민</td>
            
        </tr>
        <tr>
            <td><p>${member.mbId }</p></td>
            <td><p>${member.mbName }</p></td>
              <td><p>${member.mbPw }</p></td>
              <td><p>${member.mbNickname }</p></td> 
              <td><p>${member.mbMail }</p></td>
              <td><p>${member.mbPhone }</p></td>
              <td><p>${member.mbBirth }</p></td>
              <td><p>${member.mbFlag }</p></td>
              <td><p>${member.mbAdmin }</p></td>
        </tr>
    </table>

    <a href="/member-form?id=${member.mbId}">수정</a>
    <a href="/member-delete?id=${member.mbId}">삭제</a>
   
    
 
</body>
</html>