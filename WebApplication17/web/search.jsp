<%-- 
    Document   : search
    Created on : Apr 18, 2025, 10:58:41 AM
    Author     : asus
--%>

<%@page import="utils.AuthUtils"%>
<%@page import="dto.BookDTO"%>
<%@page import="java.util.List"%>
<%@page import="dto.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        
        <c:set var="isLogged" value="<%= AuthUtils.isLoggedIn(session)   %>"> </c:set>
        
        <c:set var="isAdmin" value="<%= AuthUtils.isAdmin(session)%>"> </c:set>
       
        <c:if test="${isLogged}" >


        
        <c:set var="value_search" value="${requestScope.search == null ? '' : requestScope.search}"></c:set>

        
        <c:if test="${isAdmin}" >
            <a href="bookForm.jsp">add</a>
        </c:if>

        <form action="MainController" method="post">
            <input type="hidden" name="action" value="search"/>
            Search Books  <input type="text" name="searchTerm" value="${value_search}" /> <br>
            <input type="submit" name="search" value="search"/>
        </form>

      
        <c:if test="${not empty requestScope.books}">

            <table border="1">
                <thead>
                    <tr>
                        <td>BookID</td>
                        <td>Title</td>
                        <td>Image</td>
                        <td>Author</td>
                        <td>PublishYear</td>
                        <td>Price</td>
                        <td>Quantity</td>
                        <c:if test="${isAdmin}">
                            <td>Action</td>
                        </c:if>
                    </tr>
                </thead>
                <tbody>
                    
                    <c:forEach var="book" items="${requestScope.books}">
                    <tr>
                        <td>${book.bookID}</td>
                        <td>${book.title}</td>
                        <td><img src="${book.image}" style="width: 150px"  /> </td>
                        <td>${book.author}</td>
                        <td>${book.pushlistYear}</td>
                        <td>${book.price}</td>
                        <td>${book.quantity}</td>
                         
                        <c:if test="${isAdmin}">
                            <td><a href="MainController?action=delete&searchTerm=${value_search}&id=${book.bookID}"><img src="assets/img/delete-file-icon.png" style="height: 25px">    </a>
                                <a href="MainController?action=edit&searchTerm=${value_search}&id=${book.bookID}"><img src="assets/img/Edit-Document-icon.png" style="height: 25px">    </a>
                            </td>
                            
                        </c:if>
                    </tr>
                     </c:forEach>
                </tbody>



            </table>
        </c:if>



            </c:if>
            <c:if test="${!isLogged}">
                <h3>you can not access this page!</h3>
            </c:if>   
                
                
     
        <%@include file="footer.jsp" %>
    </body>
</html>
