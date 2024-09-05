<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>post detail</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        function toggleLike(cmtId, mbId) {
            $.ajax({
                type: "POST",
                url: "/like-toggle",
                data: { cmtId: cmtId, mbId: mbId },
                success: function(response) {
                    const likeButton = $("#like-button-" + cmtId);
                    
                    if (response.isLiked) {
                        likeButton.text("Unlike");
                    } else {
                        likeButton.text("Like");
                    }
                    
                    $("#like-count-" + cmtId).text(response.likeCount);
                }
            });
        }

        function changeSort(sort) {
            window.location.href = "/post-detail?id=${post.pstId}&page=1&sort=" + sort;
        }
    </script>
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
    <!-- 정렬 옵션 -->
    <div>
        <label for="sort">정렬 방법:</label>
        <select id="sort" name="sort" onchange="changeSort(this.value)">
            <option value="latest" ${param.sort == 'latest' ? 'selected' : ''}>최신순</option>
            <option value="oldest" ${param.sort == 'oldest' ? 'selected' : ''}>오래된순</option>
        </select>
    </div>
    
    <!-- 댓글 목록 테이블 -->
    <table border="1">
        <tr>
            <th>Id</th>
            <th>댓글</th> 
            <th>추천</th>
        </tr>
        <tbody>
            <c:forEach var="comment" items="${commentList}">
                <tr>
                    <td>${comment.cmtId}</td>
                    <td>${comment.cmtText}</td>
                    <td>
                        <!-- like-toggle 버튼-->
                        <button id="like-button-${comment.cmtId}" 
                                data-cmt-id="${comment.cmtId}" 
                                data-mb-id="1" 
                                onclick="toggleLike(${comment.cmtId}, 1)">
                            ${comment.isLiked ? 'Unlike' : 'Like'}
                        </button>
                        <span id="like-count-${comment.cmtId}">${comment.likeCount}</span> <!-- 추천 수를 표시하는 부분 -->
                    </td>
                    <td>
                        <a href="/comment-form?id=${comment.cmtId}">수정</a>
                        <a href="/comment-delete?id=${comment.cmtId}&pstId=${param.pstId}" onclick="return confirm('댓글을 삭제하시겠습니까?');">삭제</a>
                    </td>
                    <td><p>${comment.cmtCreateDate}</p></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <!-- 페이지네비게이션 데이터 검증 -->
    <p>Total Pages: ${totalPages}</p>
    <p>Current Page: ${currentPage}</p>

    <!-- 페이지 네비게이션 -->
    <div>
        <c:if test="${totalPages > 1}">
            <c:set var="currentPage" value="${param.page != null ? param.page : 1}" />
            
            <c:if test="${currentPage > 1}">
                <a href="/post-detail?id=${post.pstId}&page=1&sort=${param.sort}">처음</a>
                <a href="/post-detail?id=${post.pstId}&page=${currentPage - 1}&sort=${param.sort}">이전</a>
            </c:if>
            
            <c:forEach var="pageNum" begin="${currentPage > 3 ? currentPage - 2 : 1}" 
                                end="${(currentPage + 2) > totalPages ? totalPages : (currentPage + 2)}">
                <c:choose>
                    <c:when test="${pageNum == currentPage}">
                        <strong>${pageNum}</strong>
                    </c:when>
                    <c:otherwise>
                        <a href="/post-detail?id=${post.pstId}&page=${pageNum}&sort=${param.sort}">${pageNum}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            
            <c:if test="${currentPage < totalPages}">
                <a href="/post-detail?id=${post.pstId}&page=${currentPage + 1}&sort=${param.sort}">다음</a>
                <a href="/post-detail?id=${post.pstId}&page=${totalPages}&sort=${param.sort}">마지막</a>
            </c:if>
        </c:if>
    </div>

    <a href="/comment-detail?pstId=${post.pstId}">댓글 추가</a>

</body>
</html>
