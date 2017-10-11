<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Form</title>
<script type="text/javascript" src="/Login/JS/RegistrationFormValidator.js"></script>
<link rel="stylesheet" type="text/css" href="/Login/CSS/RegistrationForm.css">
</head>
<body>
<form action="/Login/RegisterDao" method="post" name="registrationform" onsubmit="return validateTheRegistrationForm()">
<div class="form">
<div class="registration"><h1>Registration Form</h1></div>
<label for="name">Name</label>
<input type="text" name="name" class="name">
<label for="emailId">Email-id</label>
<input type="text" name="emailId" class="emailId">
<label for="password">Password</label>
<input type="password" name="password" class="password">
<label for="mobileNumber">Mobile Number</label>
<input type="text" name="mobileNumber" class="mobileNumber">
<input type="submit" value="Register">
</div>
</form>
</body>
</html>