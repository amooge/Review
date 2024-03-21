<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<script src="https://cdn.ckeditor.com/ckeditor5/41.1.0/classic/ckeditor.js"></script>
<meta charset="UTF-8">
<title>post detail</title>
</head>
  <body>

    <h1>Update page</h1>

    <form action="/post-add-update" method="POST">
        title: <input name="title" type="text" value="${post.pstTitle}"/>
        <textarea name="text" id="editor" value="${post.pstText}"></textarea>
        <!--
        text: <input name="text" type="text" value="${post.pstText}"/>
        -->
        <input name="pstId" type="hidden" value="${post.pstId}"/>
        <input name="mbId" type="hidden" value="1"/>
        <input name="ctgId" type="hidden" value="1"/>
        <input name="createDate" type="hidden" value="{post.pstCreateDate}">
        <input name="updateDate" type="hidden" value="{post.pstUpdateDate}">
        <input type="submit" value="save"/>
    </form>

    <script>
      ClassicEditor.create( document.querySelector( '#editor' ) );
    </script>
  
  </body>
</html>