<%-- 
    Document   : login
    Created on : Apr 14, 2025, 9:45:37 AM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <form action="MainController" method="post">
            <input type="hidden" value="login" name="action">
            Username <input type="text" name="txtUser"/><br>
            Password <input type="password" name="txtPassword"/><br>
            <input type="submit" value="login" name="login"/>
            
            
        </form>
        <%@include file="footer.jsp" %>
    </body>
</html>
