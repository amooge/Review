<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>Main page</h1>
  <table>
    <tr>
      <th>pk</th>
      <th>Title</th>
      <th>text</th>
    </tr>
  <c:forEach var="list" items="${list}" varStatus="status">
    <tr>
        <td><p>${list.pstId }</p></td>
        <td><p>${list.pstTitle }</p></td>
        <td><p>${list.pstText }</p></td>
    </tr>
  </c:forEach>
          
  </table>
</body>
</html>
