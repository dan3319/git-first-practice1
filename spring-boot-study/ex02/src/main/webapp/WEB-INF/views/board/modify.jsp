<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../includes/header.jsp" %>
    <div class="col-lg-7">
        <div class="p-5">
            <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">게시판 수정하기</h1>
            </div>
            <form role="form" action="/board/modify" method="post">
                <div class="form-group">
                    <label>Bno</label>
                    <input type="text" class="form-control" id="bno" name="bno" value='<c:out value="${board.bno}" />' readonly />
                </div>
                <div class="form-group">
                    <label>제목</label>
                    <input type="text" class="form-control" id="title" name="title" value='<c:out value="${board.title}" />' />
                </div>
                <div class="form-group">
                    <label>내용</label>
                    <textarea rows="5" class="form-control" id="content"  name="content" /><c:out value="${board.content}" /></textarea>
                </div>
                <div class="form-group">
                    <label>작성자</label>
                    <input type="text" class="form-control" id="writer"  name="writer" value='<c:out value="${board.writer}" />' readonly />
                </div>
                <div class="form-group">
                    <label>작성일</label>
                    <input class="form-control" name="regDate" value='<c:out value="${board.regdate}" />' readonly />
                </div>

                <button class="btn btn-primary" type="button"  data-oper="modify" onclick>
                    수정하기
                </button>
                <button class="btn btn-danger" type="button" data-oper="remove>
                    삭제하기
                </button>
                <button class="btn btn-default" type="button">
                    목록
                </button>
            </form>
        </div>
    </div>
</div>

<script type="text/javascript">

// 수정하기
$(document).ready(function() {
    var formObj = $("form");

    $('button').on("click", function(e) {
        e.preventDefault();

        var operation = $(this).data("oper");

        console.log(operation);

        if (operation === 'remove') {
            formObj.attr("action", "/board/remove");
        } else if (operation === 'list') {
            window.location.href = "/board/list";
            return;
        }

        formObj.submit();
    });
});

// 삭제하기
$(document).ready(function() {
    var formObj = $("form");

    $('button[data-oper="remove"]').on("click", function(e) {
        e.preventDefault();

    });
});

</script>

<%@ include file="../includes/footer.jsp" %>