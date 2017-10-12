<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<script type="text/javascript" src="JS/LoginFormValidator.js"></script>
<link rel="stylesheet" type="text/css" href="/Login/CSS/LoginForm.css">
</head>
<body>
<div class="outer">
<form action="/Login/SwitchingClass" method="post" name="loginform">
<div class="inner"><h1>Welcome</h1></div>
<div class="emailId"><label for="emailId">Email-ID</label></div>
<input type="text" name="emailId" id="emailId">
<div class="password"><label for="password">Password</label></div>
<input type="password" name="password" id="password">
<input type="submit" value="Login" name="action" onclick="return validateTheLoginForm()">
<input type="submit" value="Register" name="action">
</form>
</div>
</body>
</html>