<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="UTF-8">
<title>Member Detail Page</title>
</head>
<body>
  <h1>Member update</h1>

    <form action="/member-add-update" method="post">
        <input name="mbId" type="hidden" value="${member.mbId}"/>
       Name : <input name="mbName" type="text" value="${member.mbName}"/>
        Password :<input name="mbPw" type="password" value="${member.mbPw}"/>
        Nickname :<input name="mbNickname" type="text" value="${member.mbNickname}"/>
        Mail : <input name="mbMail" type="email" value="${member.mbMail}"/>
        Phone : <input name="mbPhone" type="tel" value="${member.mbPhone}"/>
        Birthday : <input name="mbBirth" type="date" value="${member.mbBirth}"/>
       
        <!--Admin : <input name="mbAdmin" type="hidden" value="${member.mbAdmin}"/>-->

        <input type="submit" value="save"/>
    </form>
  

      
      
    
  
  
          
  

  
</body>
</html>
