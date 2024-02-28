<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import = "java.sql.DriverManager" %>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "java.sql.Statement" %>
<%@ page import = "java.sql.ResultSet" %>
<%@ page import = "java.lang.Exception, java.sql.SQLException" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/style.css">
    <script src="/resources/js/jquery-3.7.1.min.js"></script>
    <title>공지사항 수정</title>
</head>
<body>
    <div class="card">
        <div class="card-header1">
            <h1><a href="/adminNoticeList">다은의 공지사항 글 수정</a></h1>
        </div>
        <form action="/adminNoticeUpdate" method="post" id="form1" onSubmit="return false" enctype="multipart/form-data">
        	<input type="hidden" name="num" value='<c:out value="${freeBoard.num}" />'>
	        <div class="card-write">
	            <div class="myinfo">
	                작성자<input type="text" id="writer" name="writer" placeholder="이름을 입력하세요." value='<c:out value="${freeBoard.writer}" />' readonly />
	            </div>
	            <br>
	            <div class="myinfo">
                    등록일<input type="text" id="create_date" name="create_date" value='<c:out value="${freeBoard.create_date}" />' readonly />
                    수정일<input type="text" id="update_date" name="update_date" value='<c:out value="${freeBoard.update_date}" />' readonly />
                </div>

	            <div class="title-w">
	                제목<input type="text" name="title" id="title" placeholder="제목을 입력하세요."  value='<c:out value="${freeBoard.title}" />' readonly/ >
	            </div>
	            <div class="msg">
	                내용<textarea placeholder="내용을 입력하세요." name="content" id="content" readonly ><c:out value="${freeBoard.content}"/></textarea>
	            </div>


	        </div>
	        <div class="btn-w">
	        	<input type="submit" id="modifyBtn" value="수정하기" class="input-btn-w" onClick="javascript: prevCheckTextBox();" />
	        	<button class="input-btn-w" id="confirmBtn" type="button" onclick="javascript: modifySubmit();">
                   수정완료
                </button>
        	</div>
        </form>
    </div>
    
    <script>
        // Confirm 버튼 숨기기
       $('#confirmBtn').hide();

       // 수정 가능하게 하는 메소드
       function prevCheckTextBox() {
          $('#title').attr("readonly", false);      // title 수정 가능
          $('#content').attr("readonly", false);   // content 수정 가능
          $('#confirmBtn').show();                        // Confirm 버튼 보이기
          $('#modifyBtn').hide();                           // 수정하기 버튼 숨기기
        }

    	// 수정 Confirm 메소드
       function modifySubmit() {
          document.getElementById('form1').submit();
       }
    </script>
    <%
    	// 캐시 만료를 통한 뒤로가기 방지
	    response.setHeader("Expires", "Thu, 27 Jul 2023 09:00:00 GMT"); // 현재시각보다 이전으로만 만료시간을 설정
	    response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, post-check=0, pre-check=0"); // str 로 "" 으로 넣는것보단, 상수형으로 넣어주는게 좋다. 
	    response.setHeader("Pragma", "no-cache"); 
    %>
</body>
</html>