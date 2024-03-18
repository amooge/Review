<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member detail</title>
</head>
  <body>

    <h1>Main page</h1>
    <table>
        <tr>
          <th>ID</th>
      <th>Name</th>
      <th>Password</th>
      <th>Nickname</th>
      <th>Mail</th>
      <th>Phone</th>
      <th>Birth</th>
      <th>Flag</th>
      <th>Admin</th>
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