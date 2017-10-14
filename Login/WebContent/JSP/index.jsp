<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<script type="text/javascript" src="JS/LoginFormValidator.js"></script>
<link rel="stylesheet" type="text/css" href="/Login/CSS/LoginForm.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="row">
<div class="col-xs-12">
<div class="outer">
<form action="/Login/SwitchingClass" method="post" name="loginform">
<div class="row">
<div class="col-xs-12">
<div class="inner"><h1>Welcome</h1></div>
</div>
</div>
<div class="row">
<div class="col-xs-12">
<div class="emailId"><label for="emailId">Email-ID</label></div>
<input type="text" name="emailId" id="emailId">
</div>
</div>
<div class="row">
<div class="col-xs-12">
<div class="password"><label for="password">Password</label></div>
<input type="password" name="password" id="password">
</div>
</div>
<div class="row">
<div class="col-xs-4">
<input type="submit" value="Login" name="action" onclick="return validateTheLoginForm()">
</div>
<div class="col-xs-6">
<input type="submit" value="Register" name="action">
</div>
</div>
</form>
</div>
</div>
</div>
</body>
</html>