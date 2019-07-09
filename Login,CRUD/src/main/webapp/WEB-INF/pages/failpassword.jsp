<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Incorrect Password</title>
</head>
<body>
<h1>You have entered Incorrect Password</h1>
<h3>Number of attempts left: ${attempts}</h3>
<h3>If you fail to successfully log in with the correct Password in ${attempts} attempts, the account associated with this UserName will be blocked</h3>
<a href="/hb.smvc">Log In Again</a>
</body>
</html>