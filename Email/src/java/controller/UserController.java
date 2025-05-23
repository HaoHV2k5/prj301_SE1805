/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author asus
 */
@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
          String action = request.getParameter("action");
        String url = "error.jsp";

        try {
            if ("register".equals(action)) {
                url = registerUser(request, response);
            }
        } catch (Exception e) {
            System.out.println("Error at UserController: {0}"+ e.toString());
            request.setAttribute("error", "An error occurred: " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
        
        
        
        
        
        
        
    }
    
    
     private String registerUser(HttpServletRequest request, HttpServletResponse response) {
        String url = "register.jsp";

        try {
            // Lấy tất cả các thông tin từ form đăng ký
            String userID = request.getParameter("txtUserID");
            String fullName = request.getParameter("txtFullName");
            String email = request.getParameter("txtEmail");
            String password = request.getParameter("txtPassword");
            String confirmPassword = request.getParameter("txtConfirmPassword");

            

            // Kiểm tra xem User ID đã tồn tại chưa
            UserDAO userDAO = new UserDAO();
            UserDTO existingUser = userDAO.readById(userID);

            if (existingUser != null) {
                request.setAttribute("error", "User ID already exists. Please choose another one.");
                return url;
            }

            // Kiểm tra xem Email đã tồn tại chưa
            


            // Tạo người dùng mới và thiết lập các thuộc tính
            UserDTO newUser = new UserDTO();
            newUser.setUserID(userID);
            newUser.setFullName(fullName);
            newUser.setEmail(email);
            newUser.setPassword(PasswordUtils.hashPassword(password)); // Mã hóa mật khẩu trước khi lưu
            newUser.setRoleId("US"); // Mặc định là role USER
            newUser.setStatus(true); // Mặc định là active

            // Tạo token xác thực => gợi ý để suy nghĩ
            String token = UUID.randomUUID().toString();
            newUser.setToken(token);

            // Lưu người dùng vào database
            boolean result = userDAO.create(newUser);

            if (result) {
                // Đăng ký thành công, gửi email chúc mừng
                boolean emailSent = sendCongratulationsEmail(email, fullName, userID);
                
                if (emailSent) {
                    LOGGER.log(Level.INFO, "Congratulations email sent to {0}", email);
                    request.setAttribute("success", "Registration successful! Welcome email has been sent to your email address. You can now login.");
                } else {
                    LOGGER.log(Level.WARNING, "Failed to send congratulations email to {0}", email);
                    request.setAttribute("success", "Registration successful! You can now login. (Note: Welcome email could not be sent)");
                }
                
                // Chuyển đến trang đăng nhập sau khi đăng ký thành công
                return url;
            } else {
                // Đăng ký thất bại
                request.setAttribute("error", "Registration failed. Please try again.");
                return url;
            }
        } catch (Exception e) {
           
            request.setAttribute("error", "An error occurred during registration: " + e.getMessage());
            return url;
        }
    }
    
    /**
     * Gửi email chúc mừng cho người dùng đã đăng ký thành công
     * 
     * @param email Email của người dùng
     * @param fullName Tên đầy đủ của người dùng
     * @param userID ID người dùng
     * @return true nếu gửi email thành công, false nếu thất bại
     */
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
