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
	Welcome back,
	<sec:authentication property="name" />

	<p>
		<a href="all.jsp">For everyone </a>
	</p>

	<p>
		<sec:authorize access="hasRole('USER')">
			<a href="user.jsp">For users only </a>
		</sec:authorize>
	</p>

	<p>
		<sec:authorize access="hasRole('ADMIN')">
			<a href="admin.jsp">For admins only </a>
		</sec:authorize>
	</p>

	<p></p>
	<form action="logout" method="post">
		<sec:csrfInput />
		<input type="submit" value="Sign Out" />
	</form>
	
	


</body>
</html>