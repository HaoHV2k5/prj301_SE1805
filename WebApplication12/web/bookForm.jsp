<%-- 
    Document   : bookForm
    Created on : Apr 19, 2025, 9:17:02 AM
    Author     : asus
--%>

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
                if (book == null) {
                    book = new BookDTO();
                }

            } catch (Exception e) {
            }

            String bookID_error = request.getAttribute("bookID_error") + "";
            bookID_error = bookID_error.equals("null") ? "" : bookID_error;

            String quantity_error = request.getAttribute("quantity_error") + "";
            quantity_error = quantity_error.equals("null") ? "" : quantity_error;

            String price_error = request.getAttribute("price_error") + "";
            price_error = price_error.equals("null") ? "" : price_error;

            String publistYear_error = request.getAttribute("publistYear_error") + "";
            publistYear_error = publistYear_error.equals("null") ? "" : publistYear_error;

            String title_error = request.getAttribute("title_error") + "";
            title_error = title_error.equals("null") ? "" : title_error;
            
            String author_error = request.getAttribute("author_error") + "";
            author_error = author_error.equals("null") ? "" : author_error;


        %>




        <form action="MainController" method="post">
            <input type="hidden" name="action" value="add"/>
            BookID <input type="text" name="txtBookID" value="<%= book.getBookID()%>" /> <span style="color: red"><%= bookID_error %></span>   <br>
            Title <input type="text" name="txtTitle" value="<%= book.getTitle()%>"  />  <span style="color: red"><%= title_error %></span>     <br>
            Author <input type="text" name="txtAuthor" value="<%= book.getAuthor()%>"/> <span style="color: red"><%= author_error %></span>    <br>
            PushListYear <input type="text" name="txtPushListYear" value="<%= book.getPushlistYear() == 0 ? "" : book.getPushlistYear()%>" />  <span style="color: red"><%= publistYear_error %></span>   <br>
            Price <input type="text" name="txtPrice" value="<%= book.getPrice() == 0 ? "" : book.getPrice() %>"/>  <span style="color: red"><%= price_error %></span>    <br>
            Quantity <input type="text" name="txtQuantity" value="<%= book.getQuantity() == 0 ? "" : book.getQuantity() %>" /> <span style="color: red"><%= quantity_error%></span>      <br>
            <input type="submit"  name="submit" />
            <input type="reset" value="reset" />

        </form>
    </body>
</html>
