<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Workshop 4 demo</title>
</head>
<body>
<h1><%= "Hello workshop 4!" %></h1>
<h3>This is an example of dynamic content:</h3>
<%= new java.util.Date() %>
<br />

<h3>An example of how not to use HTML in servlets:</h3>
<a href="html-servlet">HTML servlet</a>
<br />

<h3>Now we'll demonstrate using the doPost() method of a servlet:</h3>
<a href="login-servlet">Login servlet</a>


</body>
</html>