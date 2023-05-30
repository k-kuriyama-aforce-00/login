<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 

<%HttpSession session=request.getSession(); %>
<%String id = request.getParameter("id"); %>

<P>ようこそ、<%=id%>さん！</P>
<form name="Logout" method="post" action="../jsp/login.jsp">
	<input type="submit" value="Logout" />
	
</form>


</body>
</html>