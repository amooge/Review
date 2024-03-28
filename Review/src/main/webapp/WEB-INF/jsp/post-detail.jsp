<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>post detail</title>
</head>
  <body>

    <h1>Main page</h1>
    <table>
        <tr>
          <th>pk</th>
          <th>Title</th>
          <th>text</th>
        </tr>
        <tr>
            <td><p>${post.pstId }</p></td>
            <td><p>${post.pstTitle }</p></td>
            <td><p>${post.pstText }</p></td>
        </tr>
    </table>
    <c:choose>
      <c:when test="${post.pstUpdateDate eq null}">
        create date: ${post.pstCreateDate} <br/>
      </c:when>
      <c:otherwise>
        update date: ${post.pstUpdateDate} <br/>
      </c:otherwise>
    </c:choose>

    <a href="/post-form?id=${post.pstId}">수정</a>
    <a href="/post-delete?id=${post.pstId}">delete</a>
<!--
  <button type="button" onclick="href='/post-form?id=${post.pstId}'">수정</button>
-->  

<h2>댓글</h2>
    
    <table>
        <tr>
            <th>Id</th>
            <th>comment</th>
        </tr>
    <c:forEach var="commentList" items="${commentList}" varStatus="status">
        <tr>
          <td><p>${commentList.cmtId}</p></td>
          <td><p>${commentList.cmtText }</p></td>
          <td>
           <a href="/comment-form?id=${commentList.cmtId}">
           <p>수정</p>
           </a>       
           </td>
           <td>
           <a href="/comment-detail?id=${commentList.cmtId}">
           <p>삭제</p>
           </a>       
           </td>
           </tr>
          </c:forEach>
    </table>
    <a href="/comment-form?pstId=${post.pstId}">comment_add</a>

</body>
</html>