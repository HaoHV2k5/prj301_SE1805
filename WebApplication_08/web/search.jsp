<%-- 
    Document   : search
    Created on : Apr 14, 2025, 9:45:56 AM
    Author     : asus
--%>

<%@page import="dto.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            UserDTO user = (UserDTO) request.getAttribute("user");
        %>
        <h1>Welcome <%=user.getFullName()%></h1>

        <form action="#" method="post">

            Search Value <input type="text" name="txtSearch"/><br>

            <input type="submit" value="submit" name="search"/>


        </form>
    </body>
</html>
