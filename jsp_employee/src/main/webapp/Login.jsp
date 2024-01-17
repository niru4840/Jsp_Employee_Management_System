<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body align="center" style="background-color:lightgoldenrodyellow; padding-left: 450px;">

<%String message = (String) request.getAttribute("message");
if(message!=null){
%>
<%=message%>
<%} %>
<div style="border-style:solid; border-color:black; width:400px; height:400px;background-image:linear-gradient(aqua,gray);">
<form action="login" method="post">

	<h2>LOGIN</h2><br>
	
	EMAIL:-<input type="text" name="email">
	<br><br>
	<br><br>
	PASSWORD:- <input type="text" name="password">
	<br><br>
	<br><br>
	<button style="background-color:purple; font-size:20px; border-radius:10px">Login</button>
	
</form>
</div>
</body>
</html>