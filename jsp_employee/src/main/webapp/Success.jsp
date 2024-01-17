<%@page import="jsp_employee.Employee"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login success</title>
</head>
<body align="center">
<h1 style="color:purple">Employee Data</h1>

<% String name = (String) request.getAttribute("cookie");
if(name!=null){%>

<h2>Data Updated By <%=name %></h2>

<%} %>

<%List<Employee> list = (List) request.getAttribute("List"); %>
<table border="2px" align="center" style="background-image:linear-gradient(white,aqua);">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Phone</th>
		<th>Address</th>
		<th>Email</th>
		<th>Password</th>
		<th>Delete</th>
		<th>Update</th>
	</tr>
	
	<%for(Employee employee : list) { %>
	<tr>
	<td><%=employee.getId()%></td>
	<td> <%=employee.getName()%></td>
	<td><%=employee.getPhone()%></td>
	<td><%=employee.getAddress()%></td>
	<td><%=employee.getEmail()%></td>
	<td><%=employee.getPassword()%></td>	
	
	<td><a href="delete?id=<%=employee.getId()%>"><button style="color:red">DELETE</button></a></td>
	<td><a href="update?id=<%=employee.getId()%>"><button style="color:blue">UPDATE</button></a></td>
	</tr>
	
	<%  } %>
	
</table>

<h2>LOGIN SUCCESSFULL</h2>
<br>
<form action="logout" method="get">
<button style="font-size:20px; border-radius: 20px;">LogOut</button></a>
</form>
</body>
</html>