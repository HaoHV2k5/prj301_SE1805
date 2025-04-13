<%-- 
    Document   : example_01
    Created on : Apr 12, 2025, 6:51:45 PM
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
        <%! int a = 9; %>
        <% 
            double b = 0;
            b = Math.sqrt(a);
        
        %>
        Kết quả: sqrt(<%=a%>) = <span style="color: red"><%=b%></span>
    </body>
</html>
