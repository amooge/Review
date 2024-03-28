<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>comment write</title>
</head>
<body>
  <h1>write comment<h1>
  
    <form action="/comment-add-update" method="POST">
      text: <input name="cmtText" type="text" value="${comment.cmtText}"/>      
      <input name="cmtId" type="hidden" value="${comment.cmtId}"/>
      <input name="mbId" type="hidden" value="1"/>
      <input name="pstId" type="hidden" value="4"/>
      <input name="cmtParent" type="hidden" value="1"/>
      
      <input type="submit" value="save"/>
   </form>
   
</body>
</html>
