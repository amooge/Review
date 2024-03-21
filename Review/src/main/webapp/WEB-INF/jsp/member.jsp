<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang ="kr">
  <head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Member Information</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <link href="css/color.css"rel="stylesheet">
  </head>

  <body>
  
  <form name="form1" method="post" action="/memeber-form" >
    <div class="alert mycolor4" role="alert">
      Member Information
    </div>
  <div class="row">
    <div class="col-3" align="left">
      <div class="input-group input-group-sm">

        <span class="input-group-text">이름</span>
        <input type="text" name="text1" value="${mbName}" class="form-control" placeholder="Search...">
        <button class="btn mycolor4" onclick="form1.submit();">Search</button>
      </div>


    </div>
    <div class="col-9" align="right">
      <a href="/member-form" class="btn btn-sm mycolor4">추가</a>
    </div>

 </div>

  </form>
  
  <table class="table table-bordered  table-sm table=hover mymargin5" >

    <tr class="mycolor4">
      <td width="10%">아이디</td>
      <td width="10%">이름</td>
      <td width="10%">암호</td>
      <td width="10%">닉네임</td>
      <td width="20%">메일</td>
      <td width="20%">번호</td>
      <td width="20%">생일</td> 
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
   <nav aria-label="Page navigation example" >
    <ul class="pagination">
    
      <li class="page-item"><a class="page-link" href="#">이전</a></li>
      <li class="page-item"><a class="page-link" href="#">1</a></li>
      <li class="page-item"><a class="page-link" href="#">2</a></li>
      <li class="page-item"><a class="page-link" href="#">3</a></li>
      <li class="page-item"><a class="page-link" href="#">4</a></li>
      <li class="page-item"><a class="page-link" href="#">5</a></li>
      <li class="page-item"><a class="page-link" href="#">다음</a></li>
     
    </ul>
    
  </nav>
  

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
