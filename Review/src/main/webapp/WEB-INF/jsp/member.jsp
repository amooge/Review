<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Information</title>
</head>
<body>
  <h1>Member Information</h1>
  
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
  <c:forEach var="mblist" items="${mblist}" varStatus="status">
    <tr>  
      <td><p>${mblist.mbId}</p></td>
    	<td>
        <a href="/member-detail?id=${mblist.mbId}">
          <p>${mblist.mbName }</p>
        </a>

      </td>
      
        
        <td><p>${mblist.mbPw }</p></td>
        
        <td><p>${mblist.mbNickname }</p></td> 
        <td><p>${mblist.mbMail }</p></td>
        <td><p>${mblist.mbPhone }</p></td>
        <td><p>${mblist.mbBirth }</p></td>
        <td><p>${mblist.mbFlag }</p></td>
        <td><p>${mblist.mbAdmin }</p></td>
        
    </tr>
   
  </c:forEach>
  
  
   </table> 
   <a href="/member-form">Member_add</a>

</body>
</html>
