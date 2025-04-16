<%-- 
    Document   : search
    Created on : Apr 14, 2025, 9:45:56 AM
    Author     : asus
--%>

<%@page import="java.util.List"%>
<%@page import="dto.BookDTO"%>
<%@page import="dto.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp" %>



        <%
            UserDTO user = (UserDTO) session.getAttribute("user");
            if(user != null){
                %> 
        
               <h1>Welcome <%=user.getFullName()%></h1>
        <br>
        <form action="MainController" method="post">
            <input type="hidden" name="action" value="logout"/>
            <input type="submit" value="logout" name="logout"/>


        </form>



        
                <br>
        <form action="MainController" method="post">
                    <input type="hidden" name="action" value="search" />
                    Search Books <input type="text" name="searchTerm"/><br>
                    <input type="submit" name="searh"/>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <% 
                        if (request.getAttribute("books")!= null) {
                        List<BookDTO> listBook = (List<BookDTO>)request.getAttribute("books");
                    %>
                    <table border="1">
                        <tr>
                            <td>BookID</td>
                            <td>Title</td>
                            <td>Author</td>
                            <td>PublishYear</td>
                            <td>Price</td>
                            <td>Quantity</td>


                        </tr>
                        <%
                            for (BookDTO b : listBook) {
                        %> 
                        <tr>
                            <td><%=b.getBookID()%></td>
                            <td><%=b.getTitle()%></td>
                            <td><%=b.getAuthor()%></td>
                            <td><%=b.getYear()%></td>
                            <td><%=b.getPrice()%></td>
                            <td><%=b.getQuantity()%></td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                    <%     }
                    
                    
                    %>
         </form>
                
        
        
        
        <%
            }else {
            %> 
            <h1>You do no have permission to access this page!</h1>
                <%
            }

        %>
        
                
                <%@include file="footer.jsp" %>

                </body>
                </html>
