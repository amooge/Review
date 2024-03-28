<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>comment detail</title>
</head>
  <body>
    <h1>real delete?<h1>
    
      <tr>
      <td><p>${comment.cmtId }</p></td>
      <td><p>${comment.cmtText }</p></td>
      </tr>

      <a href="/comment-delete?id=${comment.cmtId}">삭제</a>
   </body>
 </html>
