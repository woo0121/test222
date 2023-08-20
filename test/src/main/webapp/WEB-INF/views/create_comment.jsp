<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>댓글 등록</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <h1>댓글 등록</h1>
    <form id="commentForm">
        <label for="boardId">게시글 ID:</label>
        <input type="number" id="boardId" name="boardId" required><br><br>
        <label for="content">댓글 내용:</label>
        <textarea id="content" name="content" required></textarea><br><br>
        <button type="submit">댓글 등록</button>
    </form>
    <div id="result"></div>

    <script>
        $(document).ready(function () {
            $("#commentForm").submit(function (event) {
                event.preventDefault();
                var boardId = $("#boardId").val();
                var content = $("#content").val();

                $.ajax({
                    url: "/app/boards/" + boardId + "/comments",
                    type: "POST",
                    contentType: "application/json",
                    data: JSON.stringify({content: content}),
                    success: function (response) {
                        $("#result").html(response);
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        $("#result").html("오류 발생: " + textStatus + ", " + errorThrown);
                    }
                });
            });
        });
    </script>
</body>
</html>
