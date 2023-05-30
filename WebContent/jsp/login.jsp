<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<span>${loginFailure }</span>
<form action="/Login/jp.co.aforce/login-sub"  method="post">
	<div>ID<input type="text" name="id" value="${param.id}"></div>
	<div>PASSWORD<input type="password" size="20" maxlength="10" name="pass"></div>
	<div><input type="submit" value="ログイン"> </div>
</form>


<a href="insert.jsp">会員登録が住んでいない人はこちら</a>

</body>
</html>