<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log Out</title>
<script type="text/javascript">
	histor.pushState(null,null,document.URL);
	window.addEventListener('popstate',function() { 
	history.pushState(null,null,document.URL)
})</script>
</head>
<body align="center">
<%session.invalidate(); %>

<h2>LogOut Successfully</h2>
<br>

Click Here For Login <a href="Login.jsp"><button>Login</button></a>

</body>
</html>