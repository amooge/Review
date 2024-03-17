<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>post list</title>
</head>
<body>
  <h1>Post page</h1>
  <table>
    <tr>
      <th>pk</th>
      <th>Title</th>
      <th>text</th>
    </tr>
  <c:forEach var="list" items="${list}" varStatus="status">
    <tr>
        <td><p>${list.pstId }</p></td>
        <td>
          <a href="/post-detail?id=${list.pstId}">
            <p>${list.pstTitle }</p>
          </a>
        </td>
        <td><p>${list.pstText }</p></td>
    </tr>
  </c:forEach>
          
  </table>
  <a href="/post-form">post_add</a>
</body>
</html>
