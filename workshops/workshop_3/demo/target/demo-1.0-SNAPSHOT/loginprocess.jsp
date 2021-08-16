<jsp:setProperty property="*" name="obj"/>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    boolean status=LoginDao.validate(obj);
    if(status){
        out.print("You r successfully logged in");
        session.setAttribute("session","TRUE");
    }
    else
    {
        out.print("Sorry, email or password error");

</body>
</html>
