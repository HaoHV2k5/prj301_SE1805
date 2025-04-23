<%-- 
    Document   : bookForm
    Created on : Apr 19, 2025, 8:58:02 PM
    Author     : asus
--%>

<%@page import="utils.AuthUtils"%>
<%@page import="dto.UserDTO"%>
<%@page import="dto.BookDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <c:set var="isLogged" value="<%= AuthUtils.isLoggedIn(session)%>"> </c:set>

        <c:set var="isAdmin" value="<%= AuthUtils.isAdmin(session)%>"> </c:set>
        
       
        
        
        
        <c:if test="${isLogged}">

            <c:if test="${isAdmin}">
                
                <jsp:useBean id="book" class="dto.BookDTO" scope="request"></jsp:useBean>
                <form action="MainController" method="post">
                    <input type="hidden" name="action" value="add" />
                    BookID <input type="text" name="BookID"  value="${book.bookID}" />
                <c:if test="${not empty book_error}">
                    <span style="color: red">${book_error}</span>
                </c:if>
                    <br>
                    Title <input type="text" name="Title" value="${book.title}"/><br>
                    Author <input type="text" name="Author" value="${book.author}"/><br>
                    PushlistYear <input type="text" name="PushlistYear" value="${book.pushlistYear == 0 ? "" : book.pushlistYear}"/><br>
                    Price <input type="text" name="Price" value="${book.price == 0 ? "" : book.price}"/><br>

                    Quantity <input type="text" name="Quantity" value="${book.quantity == 0 ? "" : book.quantity}"/>
                    
                    <c:if test="${not empty quantity_error}">
                    <span style="color: red">${quantity_error}</span>
                    </c:if>
                    <br>
                    
                    
                    <input type="submit" value="submit" />
                    <input type="reset" value="reset"/>



                </form>

            </c:if>
            
        </c:if>
        <c:if test="${!isLogged}">
                 <h3> you do not have permission to accsess this page!</h3>
            </c:if>




    </body>
</html>
