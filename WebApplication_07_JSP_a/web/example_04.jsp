<%-- 
    Document   : example_04
    Created on : Apr 12, 2025, 7:27:55 PM
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
        <!--lam bang cuu chuong-->
        <%
            for (int i = 2; i <= 9; i++) {
                for (int j = 1; j <= 10; j++) {
                    int kq = i * j;
        %>
        <%= i%> * <%= j%> = <%=kq%> <br>

        <%
            } %> 

        <hr>   
        <%
            }


        %>

    </body>
</html>
