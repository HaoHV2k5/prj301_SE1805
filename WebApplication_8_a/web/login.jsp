<%-- 
    Document   : login
    Created on : Apr 14, 2025, 10:41:42 PM
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
        <form action="MainController" method="post">
            <input type="hidden" name="action" value="login" />
            Username <input type="text" name="txtA"/><br>
            Password <input type="password" name="txtB"/><br>
            <input type="submit" value="submit"/>
            
            
        </form>
    </body>
</html>
