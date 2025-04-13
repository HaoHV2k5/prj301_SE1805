<%-- 
    Document   : output
    Created on : Apr 12, 2025, 9:18:08 PM
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
        <% 
            int n = (int)request.getAttribute("n");
        %>
        <h1>Bang cuu chuong <%=n%></h1> 

        <%
        for (int j = 1; j <= 10; j++) {
                    int kq = n * j;
        %>
        <%= n%> * <%= j%> = <%=kq%> <br>

        <%
            } %> 
    </body>
</html>
