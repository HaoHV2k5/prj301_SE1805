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

    public static final String LOGIN = "login.jsp";

    public static UserDTO getUserByID(String username) {
        UserDAO user = new UserDAO();
        UserDTO id = user.readById(username);
        return id;
    }

    public static boolean isValid(String username, String password) {
        UserDTO user = getUserByID(username);
        return user != null && user.getPassword().equals(password);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN;
        try {
            String action = request.getParameter("action") + "";
            if (action.equals("null")) {
                url = LOGIN;
            } else {
                if (action.equals("login")) {
                    String username = request.getParameter("userName") + "";
                    String password = request.getParameter("password") + "";
                    if (isValid(username, password)) {
                        url = "search.jsp";
                        UserDTO user = getUserByID(username);
                        request.getSession().setAttribute("user", user);
                    } else {
                        url = "login.jsp";
                        request.setAttribute("message", "your username or password is not valid");
                    }

                } else if (action.equals("logout")) {
                    url = "login.jsp";
                    request.getSession().invalidate();
                } else if (action.equals("searchTerm")) {
                    url = "search.jsp";
                    String searchTerm = request.getParameter("search") + "";

                    BookDAO bDao = new BookDAO();
                    List<BookDTO> list = bDao.searchByTitle2(searchTerm);
                    request.setAttribute("books", list);
                    request.setAttribute("searchTerm", searchTerm);

                }else if (action.equals("delete")) {
                    BookDAO bDao = new BookDAO();
                    String id = request.getParameter("id")+"";
                    bDao.updateQuantityToZero(id);                     
                    
                    
                    url = "search.jsp";
                    String searchTerm = request.getParameter("search") + "";

                    List<BookDTO> list = bDao.searchByTitle2(searchTerm);
                    request.setAttribute("books", list);
                    request.setAttribute("searchTerm", searchTerm);

                }
            }

        } catch (Exception e) {
            System.out.println(e.toString());
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
