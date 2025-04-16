<%-- 
    Document   : search
    Created on : Apr 14, 2025, 9:45:56 AM
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
                <%@include file="header.jsp" %>

        <% 
            UserDTO user = (UserDTO) session.getAttribute("user");
            if(user != null){
                %> 
        
                     <h1>Welcome <%=user.getFullName()%></h1>
        <form action="MainController" method="post">
            <input type="hidden" name="action" value="logout" />
            <input type="submit" value="logout"  />
            
        </form>

        <form action="MainController" method="post">
            <input type="hidden" name="action" value="search" />
            Search Value <input type="text" name="searchTerm"/><br>

            <input type="submit" name="search"/>


        </form>
        <% 
            if(request.getAttribute("books")!= null ){
                 List<BookDTO> listBooks = (List<BookDTO>)request.getAttribute("books");
                 %> 
        
                 <table border="1">
                     <tr>
                         <td>BookID</td>
                         <td>Title</td>
                         <td>Author</td>
                         <td>Publish Year</td>
                         <td>Price</td>
                         <td>Quantit</td>
                         
                         
                     </tr>
                     
                     <% 
                       for (BookDTO b : listBooks) {
                               

                     %>
                             <tr>
                         <td><%= b.getBookID()%></td>
                         <td><%= b.getTitle()%></td>
                         <td><%= b.getAuthor()%></td>
                         <td><%= b.getPublishYear()%></td>
                         <td><%= b.getPrice()%></td>
                         <td><%= b.getQuantity()%></td>
                         
                         
                     </tr>  

                     <%
                           }
                     
                     %>                     
                 </table>
        <%    
            }
        %>
        
        
        <%
            }else{
        %> <h4>you do no have permittion to accsess this page !</h4> <%
}
        %>
       
                <%@include file="footer.jsp" %>

    </body>
</html>
