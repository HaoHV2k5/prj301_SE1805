<%-- 
    Document   : search
    Created on : Apr 17, 2025, 8:37:18 PM
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


        <% UserDTO user = (UserDTO) session.getAttribute("user");
            if(user != null){
                %> 
        
                        <h4> Welcome <%= user.getFullName()%> </h4>
        <form action="MainController" method="post">
            <input type="hidden" name="action" value="logout" />
            <input type="submit" value="logout" />
        </form>
        <% String search=request.getAttribute("searchTerm")+"";
            search = search.equals("null")?"":search;
        
        %>
        <form action="MainController" method="post">
            <input type="hidden" name="action" value="searchTerm" />
            Search Books <input type="text"  name="search" value="<%= search%>"/> <br>
            <input type="submit" value="searchTerm"  />
        </form>
        <% 
            if(request.getAttribute("books") != null){
                List<BookDTO> list = (List<BookDTO>)request.getAttribute("books");
                
        %> 
        
                <table border="1">
            <tr>
                <td>BookID</td>
                <td>Title</td>
                <td>Author</td>
                <td>PublishYear</td>
                <td>Price</td>
                <td>Quantity</td>               
                <td>Action</td>

                
            </tr>
            <% for (BookDTO book : list) {
                
            %> 
            <tr>
                <td><%=book.getBookID()%></td>
                <td><%=book.getTitle()%></td>
                <td><%=book.getAuthor()%></td>
                <td><%=book.getPublishYear()%></td>
                <td><%=book.getPrice()%></td>
                <td><%=book.getQuantity()%></td>
                <td> <a href="MainController?action=delete&id=<%=book.getBookID()%>&search=<%= search%>"><img src="assets/imgs/delete-file-icon.png " style="height: 25px"</a>  </td>

            </tr>
            
            
            
            <%
                }
            %>
            
            
            
        </table>
        
        
        
        
        
        <%
            }
        
        
        
        
        %>
        
        
        
        
        
        <%
            }else{ %> <h3>you do not have permission to access this page !</h3> <%

}
        
        
        %>
        
        
        
        
        <%@include file="footer.jsp" %>

    </body>
</html>
