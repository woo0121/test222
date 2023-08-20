<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>Home</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
 <h1>Home</h1>

    <h2>로그인</h2>
    <form id="loginForm">
        <label for="username">아이디:</label>
        <input type="text" id="username" name="username" required><br><br>
        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password" required><br><br>
        <button="submit">로그인</button>
    </form>
    <div id="loginResult"></div>

    <hr>

    <h2>회원가입</h2>
    <form id="signup">
        <label for="signupUsername">아이디:</label>
        <input type="text" id="signupUsername" name="signupUsername" required><br><br>
        <label for="signupPassword">비밀번호:</label>
        <input type="password" id="signupPassword" name="signupassword" required><br><br>
        <button type="submit">회원가입</button>
    </form>
    <div id="signupResult"></div>

    <hr>

    <h2>댓글 등록</h2>
    <form id="commentForm">
        <label for="boardId">게시글 ID:</label>
        <input type="number" id="boardId" name="boardId" required><br><br>
        <label for="content">댓글 내용:</label>
        <textarea id="content" namecontent" required></textarea><br><br>
        <button type="submit">댓글 등록</button>
    </form>
    <div id="result"></div>

    <script>
        // 로그인
        $(document).ready(function () {
            $("#loginForm").submit(function (event) {
                event.preventDefault();
                var username = $("#username").val();
                var password = $("#password").val();

                $.ajax({
                    url: "/api/login",
                    type: "POST",
                    contentType: "application/json",
                    data: JSON.stringify({username: username, password: password}),
                    success: function (response) {
                        $("#loginResult").html(response);
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        $("#loginResult").html("오류 발생: " + textStatus + ", " + errorThrown);
                    }
                });
            });
        });

        // 회원가입
        $(document).ready(function () {
            $("#signupForm").submit(function (event) {
                event.preventDefault();
                var signupUsername = $("#signupUsername").val();
                var signupPassword = $("#signupPassword").val();

                $.ajax({
                    url: "/api/signup",
                    type: "POST",
                    contentType: "application/json",
                    data: JSON.stringify({username: signupUsername, password: signupPassword}),
                    success: function (response) {
                        $("#signupResult").html(response);
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        $("#signupResult").html("오류 발생: " + textStatus + ", " + errorThrown);
                    }
                });
            });
        });

        // 댓글 등록
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
