<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>post detail</title>
</head>
  <body>

    <h1>Update page</h1>

    <form action="/post-add-update" method="POST">
        title: <input name="title" type="text" value="${post.pstTitle}"/>
        text: <input name="text" type="text" value="${post.pstText}"/>
        <input name="pstId" type="hidden" value="${post.pstId}"/>
        <input name="mbId" type="hidden" value="1"/>
        <input name="ctgId" type="hidden" value="1"/>

        <input type="submit" value="save"/>
    </form>
  
  </body>
</html>