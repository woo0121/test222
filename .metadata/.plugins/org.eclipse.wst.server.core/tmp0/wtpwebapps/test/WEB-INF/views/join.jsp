<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JOIN</h1>

<form name="joinform" action="${pageContext.request.contextPath}/join" method="post" onsubmit="return false"> 
    
        <label for="username">아이디:</label>
        <input type="text" id="username" name="username" required><br>
        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password" required><br>
        <label for="passwordConfirm">비밀번호 확인:</label>
        <input type="password" id="passwordConfirm" name="passwordConfirm" required><br>
       
	<button onclick="isValid()">JOIN</button>
</form>
 
 <script>
 		const isValid = ()=>{
 			const form = document.joinform;
 			if(form.username.value.trim()==""){
 				alert("USERNAME을 입력하세요.");
 				return;
 			}
 			if(form.password.value.trim()==""){
 				alert("PASSWORD을 입력하세요.");
 				return;
 			}	
 			form.submit();
 		}
 </script>

</body>
</html>