<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp Page</title>
</head>
<body align="center" style="background-color:lightgoldenrodyellow;  padding-left: 400px">

<h1 style=" padding-left:70px; width: 250px;" align="center">Employee SignUp </h1>
			<br>
			<div style="border-style:solid; border-color:black; width:400px; height:400px;background-image:linear-gradient(aqua,gray);" >
	<form action="signup" method="post" >
	<br>
		ID:- <input type="text" name="id" placeholder=" Id">
		<br><br>
		Name:- <input type="text" name="name" placeholder=" Name">
		<br><br>	
		Phone:- <input type="text" name="phone" placeholder="Phone">
		<br><br>
		Address:- <input type="text" name="address" placeholder="Address">
		<br><br>
		Email:- <input type="text" name="email" placeholder=" Email">
		<br><br>
		Password:- <input type="text" name="password" placeholder=" Password">
		<br><br>
		<button style="background-color:lightpink; font-size:15px">SUBMIT</button>
		
		<br><br><br>
		<h4 style="color:pink;">All Fields Are Mandatory*</h4>
		
	</form>
</div>
</body>
</html>