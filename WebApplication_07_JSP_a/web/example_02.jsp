<%-- 
    Document   : example_02
    Created on : Apr 12, 2025, 7:12:19 PM
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
        
            for(int i=1 ; i <= 99 ; i++){
                %>
                <%=i%><br> 
        <%
            }
        
        
        %>
    </body>
</html>
