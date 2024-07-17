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

  <!-- 
  검색을 위한 form
  서버에 search 와 kind를 전송
  -->
  <form name="search" action="/post" method="post">
    <input name="search" type="search" value="${searchList.search}"/>
    <input type="submit" value="search"/>

    <select name="kind" id="search" onchange="sbm()">
      <c:choose>
        <c:when test="${searchList.kind eq 0}">
          <option value="0" selected>latest</option>
          <option value="1">score</option>
        </c:when>
        <c:otherwise>
          <option value="0">latest</option>
          <option value="1" selected>score</option>
        </c:otherwise>
      </c:choose>
    </select>
  </form>

  

  <table>
    <tr>
      <th>pk</th>
      <th>Title</th>
      <th>text</th>
    </tr>
  <c:forEach var="list" items="${list.content}" varStatus="status">
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
<!-- 이전 그룹으로 이동 -->
<c:if test="${not list.first}">
  <a href="javascript:void(0);" onclick="PageJump('${group - 1}')"> << </a>
</c:if>

<!-- 
    페이지 숫자 뿌리는 루프 
    begin과 end는 페이지 네이션 공식 참조
    i 가 마지막 페이지 보다 클 경우 출력 X
-->
  <c:forEach var="i" begin="${(group - 1) * list.size}" end="${group * list.size - 1}" step="1">
    <c:if test="${i < list.totalPages}">
      <a href="javascript:void(0);" onclick="PageMove('${i}')">${i + 1}</a>
    </c:if>
  </c:forEach>
          

<!-- 다음 그룹으로 이동-->
<c:if test="${not list.last}">
  <a href="javascript:void(0);" onclick="PageJump('${group + 1}')"> >> </a>
</c:if>


  <br>
  <br>
  <a href="/post-form">post_add</a>

  <script>

    /*
     * serch form 을 서버에 전송하는 함수
     */
    function sbm(){
      document.search.submit();
    }

    /*
     * 페이지 이동 함수
     * 이동 할 페이지가 음수 또는 마지막 페이지를 넘어갈 경우를 방지함
     */
    function PageMove(pageNumber){
        if(pageNumber < 0){
          pageNumber = 1;
          location.href = "post?page=" + pageNumber + "&search=${searchList.search}&kind=${searchList.kind}&group=${group}";

        }else if(pageNumber >= '${list.totalPages}'){
          pageNumber = '${list.totalPages - 1}';
          location.href = "post?page=" + pageNumber + "&search=${searchList.search}&kind=${searchList.kind}&group=${group}";

        }else{
          location.href = "post?page=" + pageNumber + "&search=${searchList.search}&kind=${searchList.kind}&group=${group}";
        }
    }

    /*
     * 그룹 이동 함수
     */
    function PageJump(num){
      groupToPage = (num - 1) * 5
      location.href = "post?page=" + groupToPage + "&search=${searchList.search}&kind=${searchList.kind}&group=" + num;
    }
  </script>
  
</body>
</html>