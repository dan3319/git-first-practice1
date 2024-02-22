<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../includes/header.jsp" %>
    <div class="col-lg-7">
        <div class="p-5">
            <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">게시판 상세조회</h1>
            </div>
            <!-- action: form 데이터를 처리할 프로그램의 URI를 지정한다.
                         onsubmit: 양식 제출 이벤트가 발생할 때의 동작을 지정한다.
                          action을 바로 실행하지 않고, onsubmit을 거친 후, action을 실행함. -->
            <form action="/board/remove" method="post" id="form1" onSubmit="return false">
                <div class="form-group">
                    <label>Bno</label>
                    <input type="text" class="form-control" id="bno" name="bno" value='<c:out value="${board.bno}" />' readonly />
                </div>
                <div class="form-group">
                    <label>제목</label>
                    <input type="text" class="form-control" id="title" name="title" value='<c:out value="${board.title}" />' readonly />
                </div>
                <div class="form-group">
                    <label>내용</label>
                    <textarea rows="5" class="form-control" id="content"  name="content" readonly /><c:out value="${board.content}" /></textarea>
                </div>
                <div class="form-group">
                    <label>작성자</label>
                    <input type="text" class="form-control" id="writer"  name="writer" value='<c:out value="${board.writer}" />' readonly />
                </div>
                <!--
                <button class="btn btn-primary" type="button" onClick='location.href="/board/modify?bno=<c:out value="${board.bno}" />"'>
                -->
                <button class="btn btn-primary" id="modifyBtn" type="button" onClick='javascript: boardModify();'>
                    수정하기
                </button>
                <button class="btn btn-primary" id="confirmBtn" type="button" onclick="javascript: modifySubmit();">
                   Confirm
                </button>
                <button class="btn btn-info" id="listBtn" type="button" onClick='location.href="/board/list"'>
                    목록
                </button>
                <button class="btn btn-danger" id="deleteBtn" type="button" onClick='javascript: boardDelete();'>
                    삭제하기
                </button>
            </form>
        </div>
    </div>

<script>
   // Confirm 버튼 숨기기
   $('#confirmBtn').hide();

   // 수정 가능하게 하는 메소드
   function boardModify() {
      $('#title').attr("readonly", false);      // title 수정 가능
      $('#content').attr("readonly", false);   // content 수정 가능
      $('#confirmBtn').show();                        // Confirm 버튼 보이기
      $('#modifyBtn').hide();                           // 수정하기 버튼 숨기기
      $('#deleteBtn').hide();                           // 삭제하기 버튼 숨기기
   }

   // 수정 Confirm 메소드
   function modifySubmit() {
      const form1 = document.getElementById('form1');
      form1.action = "/board/modify";

      form1.submit();
   }

   // 삭제 메소드
   function boardDelete() {
      const form1 = document.getElementById('form1');
      form1.action = "/board/remove";

      form1.submit();
   }
</script>

<%@ include file="../includes/footer.jsp" %>