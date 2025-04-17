<%-- 
    Document   : login
    Created on : Apr 17, 2025, 8:36:57 PM
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
            <input type="hidden" name="action"  value="login"  />
            Username <input type="text" name="userName"   /><br>
            Password <input type="password" name="password"   /><br>
            <input type="submit" value="submit" name="login" />
        </form>

        <%  String message = request.getAttribute("message") + "";%>
        <%= message.equals("null") ? "" : message%>

        <%@include file="footer.jsp" %>



    </body>
</html>
