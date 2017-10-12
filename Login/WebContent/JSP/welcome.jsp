<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome <%= session.getAttribute("name") %></title>
</head>
<body>
<table width="1500">
<tr>
<td>Home Page</td>
<td>User:<%= session.getAttribute("name") %></td>
<td>
<form action="/Login/SessionController" method="post">
<input type="submit" value="Logout" align="right">
</form>
</td>
</tr>
</table>
</body>
</html>