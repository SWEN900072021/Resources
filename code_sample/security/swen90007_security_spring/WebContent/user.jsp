<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<p>Welcome back, <sec:authentication property="name" /></p>

	<p>This is for users only.</p>

	<p></p>
	<form action="logout" method="post">
		<sec:csrfInput />
		<input type="submit" value="Sign Out" />
	</form>


</body>
</html>