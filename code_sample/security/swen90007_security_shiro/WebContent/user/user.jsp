<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<p>
		Welcome back,
		<shiro:principal/>
	</p>

	<p>This is for users only.</p>

	<p></p>
	<form id="logout_form" name="logout_form" action="${pageContext.request.contextPath}/logout"
		method="post">
		<input type="submit" value="Logout">
	</form>


</body>
</html>