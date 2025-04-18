<%-- 
    Document   : search
    Created on : Apr 18, 2025, 10:58:41 AM
    Author     : asus
--%>

<%@page import="dto.BookDTO"%>
<%@page import="java.util.List"%>
<%@page import="dto.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% UserDTO user = (UserDTO) session.getAttribute("user");
            if (user != null) {
        %> 

        <h3>Welcome <%=user.getFullName()%></h3>

        <form action="MainController" method="post">
            <input type="hidden" name="action" value="logout"/>

            <input type="submit" name="logout" value="logout"/>
        </form>
        <% String value_search = request.getAttribute("search") + "";
            value_search = value_search.equals("null") ? "" : value_search;
        %>
        <form action="MainController" method="post">
            <input type="hidden" name="action" value="search"/>
            Search Books  <input type="text" name="searchTerm" value="<%= value_search%>" /> <br>
            <input type="submit" name="search" value="search"/>
        </form>

        <%
            if (request.getAttribute("books") != null) {
                List<BookDTO> list = (List<BookDTO>) request.getAttribute("books");
        %> 

        <table border="1">
            <thead>
                <tr>
                    <td>BookID</td>
                    <td>Title</td>
                    <td>Author</td>
                    <td>PublishYear</td>
                    <td>Price</td>
                    <td>Quantity</td>
                    <td>Action</td>


                </tr>
            </thead>
            <tbody>
                <%
                    for (BookDTO book : list) {

                %> 

                <tr>
                    <td><%= book.getBookID()%></td>
                    <td><%= book.getTitle()%></td>
                    <td><%= book.getAuthor()%></td>
                    <td><%= book.getPushlistYear()%></td>
                    <td><%= book.getPrice()%></td>
                    <td><%= book.getQuantity()%></td>
                    <td><a href="MainController?action=delete&searchTerm=<%= value_search%>&id=<%= book.getBookID()%>"><img src="assets/img/delete-file-icon.png" style="height: 25px">    </a></td>

                </tr>
                <%
                    }


                %>
            </tbody>



        </table>

        <%            }
        %>

        <%
        } else {
        %> <h3>you can not access this page!</h3> <%
    }

        %>

    </body>
</html>
