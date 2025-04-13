<%-- 
    Document   : example_03
    Created on : Apr 12, 2025, 7:20:15 PM
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
        <%! int a = 101;%>
        <%
            if (a % 2 == 0) {
        %>
        <%= a%> la so chan
        <%
        } else {
        %>
        <%=a%> la so le

        <%

            }
        %>


    </body>
</html>
