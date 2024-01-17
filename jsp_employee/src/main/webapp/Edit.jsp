<%@page import="jsp_employee.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="padding-left: 50px; padding-top: 20px">

<% Employee employee = (Employee) request.getAttribute("emp");%>
<h1>Update Employee Detail</h1>
<div style="border-style:solid; border-color:black; width:400px; height:400px;background-image:linear-gradient(aqua,gray); padding-left: 20px">
<form action="edit" method="post">
<br><br>
		ID:- <input type="" name="id" value=<%=employee.getId()%> readonly="true">
		<br><br>
		Name:- 	<input type="text" name="name" value=<%=employee.getName()%>>
		<br><br>	
		Phone:- <input type="text" name="phone" value=<%=employee.getPhone()%>>
		<br><br>
		Address:- <input type="text" name="address" value=<%=employee.getAddress()%>>
		<br><br>
		Email:-  <input type="text" name="email" value=<%=employee.getEmail()%>>
		<br><br>
		Password:- <input type="text" name="password" value=<%=employee.getPassword()%>>
		<br><br>
		<button style="background-color:lightgreen; font-size:18px; border-radius:10px">SUBMIT</button>
		<br><br>
		
</form>
</div>
</body>
</html>