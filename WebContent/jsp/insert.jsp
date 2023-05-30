<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>登録内容を入力してください</h1>

<form action="/Login/jp.co.aforce/insert" method="post">
	<div>ID<input type="text" name="newId" >(５文字)</div>
	<div>PASSWORD<input type="password" size="20" maxlength="10" name="newPass">(10文字以下)</div>
	<div>名前<input type="text" name="newName" >(10文字以下)</div>
	<div><input type="submit" value="登録"> </div>
</form>

</body>
</html>