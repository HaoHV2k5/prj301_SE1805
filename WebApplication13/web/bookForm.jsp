<%-- 
    Document   : bookForm
    Created on : Apr 19, 2025, 8:58:02 PM
    Author     : asus
--%>

<%@page import="utils.AuthUtils"%>
<%@page import="dto.UserDTO"%>
<%@page import="dto.BookDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            BookDTO book = new BookDTO();
            try {
                    book = (BookDTO) request.getAttribute("book");
                    if(book == null){
                        book = new BookDTO();
                    }
                
                
                } catch (Exception e) {
                }
        
             String book_error   = request.getAttribute("book_error")+"";
             book_error = book_error.equals("null")?"" : book_error;
        
             String quantity_error   = request.getAttribute("quantity_error")+"";
             quantity_error = quantity_error.equals("null")?"" : quantity_error;


        %>
        
        <%
                        if (AuthUtils.isAdmin(session)) {
                    %>     
        
        
        <form action="MainController" method="post">
            <input type="hidden" name="action" value="add" />
            BookID <input type="text" name="BookID"  value="<%= book.getBookID()    %>" /><span style="color: red"><%=  book_error  %></span><br>
            Title <input type="text" name="Title" value="<%= book.getTitle()%>"/><br>
            Author <input type="text" name="Author" value="<%= book.getAuthor()%>"/><br>
            PushlistYear <input type="text" name="PushlistYear" value="<%= book.getPushlistYear()==0?"":book.getPushlistYear()%>"/><br>
            Price <input type="text" name="Price" value="<%= book.getPrice()==0?"":book.getPrice()%>"/><br>
            Quantity <input type="text" name="Quantity" value="<%= book.getQuantity()==0?"":book.getQuantity() %>"/><span style="color: red"><%=  quantity_error  %></span><br>
            <input type="submit" value="submit" />
            <input type="reset" value="reset"/>
            
            <% }else{
            %> <h3> you do not have permission to accsess this page!</h3> <%
            
            }%>
            
        </form>
    </body>
</html>
