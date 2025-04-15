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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asus
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})

public class MainController extends HttpServlet {

    public UserDTO getUser(String userID) {
        UserDAO uDAO = new UserDAO();
        return uDAO.readById(userID);
    }

    public boolean isValidLogin(String userName, String password) {
        UserDTO user = getUser(userName);
        return user != null && user.getPassword().equals(password);
    }
    public static String LOGIN_PAGE = "login.jsp";
    public static String url;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String action = request.getParameter("action");
            url = null;
            if (action == null) {
                url = LOGIN_PAGE;

            } else {
               if(action.equals("login")){
                    String userName = request.getParameter("txtUser");
                String password = request.getParameter("txtPassword");
                if (isValidLogin(userName, password)) {
                    url = "search.jsp";
                    UserDTO user = getUser(userName);
                    request.setAttribute("user", user);
                } else {
                    url = "invalid.jsp";
                }
               }else if(action.equals("logout")){
                   url = "logout_confirm.jsp";
               
               }

            }
        } catch (Exception e) {
            log("try catch errors: "+e.toString());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }

    }

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
