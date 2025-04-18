/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BookDAO;
import dao.UserDAO;
import dto.BookDTO;
import dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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

    public static UserDTO getUserByID(String id){
        UserDAO user = new UserDAO();
        return user.readById(id);
    }
    public static boolean isValidLogin(String username, String password){
        UserDTO user = getUserByID(username);
        return user != null && user.getPassword().equals(password);
    }
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "login.jsp";
        try {
            String action = request.getParameter("action") + "";
            if (action == null) {
                url = "login.jsp";
            }
            else{
                if(action.equals("login")){
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    if(isValidLogin(username, password)){
                        url = "search.jsp";
                        UserDTO user = getUserByID(username);
                        request.getSession().setAttribute("user", user);
                    }else{
                        url = "login.jsp";
                        request.setAttribute("message", "your username or password is not valid!");
                    }
                }else if(action.equals("logout")){
                    url ="login.jsp";
                }else if(action.equals("search")){
                    url = "search.jsp";
                    String searchTerm = request.getParameter("searchTerm")+"";
                    BookDAO bdao = new BookDAO();
                    List<BookDTO> books = new ArrayList<>();
                    books = bdao.searchByTitle(searchTerm);
                    request.setAttribute("books", books);
                    request.setAttribute("search",searchTerm);
                }else if(action.equals("delete")){
                    url = "search.jsp";
                    BookDAO bdao = new BookDAO();
                    String id = request.getParameter("id")+"";
                    bdao.updateQuantityToZero(id);
                    
                    
                    String searchTerm = request.getParameter("searchTerm")+"";
                    List<BookDTO> books = new ArrayList<>();
                    books = bdao.searchByTitle(searchTerm);
                    request.setAttribute("books", books);
                    request.setAttribute("searchTerm",searchTerm);
                }
                
            }
        } catch (Exception e) {
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
