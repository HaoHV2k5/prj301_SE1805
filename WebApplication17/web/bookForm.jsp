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
                <c:set var="action" value="${requestScope.action == 'update' ?  'update' : 'add'  }" > </c:set>
                    <input type="hidden" name="action" value="${action}" />
                    
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
<!--                    Image <input type="text" name="image" value="${book.image}"/><br>
                    
                    
                    -->
                     <div >
                        <label for="txtImage">Book Cover Image:</label>
                        <input type="hidden" id="txtImage" name="image" value="${book.image}"/>
                        <div >
                            <div >
                                <button type="button" >Choose an Image</button>
                                <input type="file" id="imageUpload" accept="image/*"/>
                            </div>
                            <div  id="fileInfo">No file selected</div>
                            <div id="progressContainer">
                                <div  id="progressBar"></div>
                            </div>
                        </div>
                        <c:if test="${not empty requestScope.txtImage_error}">
                            <div >${requestScope.txtImage_error}</div>
                        </c:if>
                        <div  id="imagePreview">
                            <c:if test="${not empty book.image}">
                                <img src="${book.image}" alt="${book.title}"/>
                            </c:if>
                        </div>
                    </div>


                        <input type="submit" value="submit" />
                    <input type="reset" value="reset"/>
                </form>
                        

            </c:if>
            
        </c:if>
        <c:if test="${!isLogged}">
                 <h3> you do not have permission to accsess this page!</h3>
            </c:if>

                 
                 <script>
            // JavaScript để cải thiện trải nghiệm người dùng
            document.addEventListener('DOMContentLoaded', function () {
                // Preview image when URL is entered
                document.getElementById('txtImage').addEventListener('input', function () {
                    const imageUrl = this.value.trim();
                    let previewContainer = document.querySelector('.image-preview');

                    if (!previewContainer) {
                        previewContainer = document.createElement('div');
                        previewContainer.className = 'image-preview';
                        this.parentNode.appendChild(previewContainer);
                    }

                    if (imageUrl) {
                        // Check if it's a URL or base64 data
                        if (imageUrl.startsWith('data:image') || imageUrl.startsWith('http')) {
                            previewContainer.innerHTML = `<img src="${imageUrl}" alt="Preview" onerror="this.src='assets/images/placeholder.png'; this.alt='Image not available';">`;
                        } else {
                            previewContainer.innerHTML = '<p>Enter a valid image URL or base64 data</p>';
                        }
                    } else {
                        previewContainer.innerHTML = '';
                    }
                });
            });
        </script>
        
         <!-- Thêm jQuery từ CDN -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        
        <script src="assets/js/book-form.js" />

    </body>
</html>
