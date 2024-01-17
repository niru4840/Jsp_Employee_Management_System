<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp Failed</title>
</head>
<body>

<%String message = (String) request.getAttribute("message");
if(message!=null){
%>
<%=message%>
<%} %>

	
	<h3>Click Here To SignUp</h3><br>
	<a href="SignUp.jsp"><button>Login</button></a>
	

</body>
</html>