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
            <td><p>${list.pstId }</p></td>
            <td>
              <a href="/post-form?id=${list.pstId}">
                <p>${list.pstTitle }</p>
              </a>
            </td>
            <td><p>${list.pstText }</p></td>
        </tr>
      
              
      </table>
</body>
</html>