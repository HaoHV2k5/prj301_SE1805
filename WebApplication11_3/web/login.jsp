<%-- 
    Document   : login
    Created on : Apr 18, 2025, 10:56:17 AM
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
            <input type="hidden" name="action" value="login"/>
            Username<input type="text" name="username"/><br>
            Password<input type="password" name="password"/><br>
            <input type="submit" name="login"/><br>
        </form>
        <% String message = request.getAttribute("message")+"";   %>
        <%= message.equals("null")?"":message    %>
        
    </body>
</html>
