/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asus
 */
@WebServlet(name = "TUSCLN", urlPatterns = {"/TUSCLN"})
public class TUSCLN extends HttpServlet {

    public int GCD(int a, int b){
        if(b ==0) return a;
        return GCD(b,a%b);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String textA = request.getParameter("txtA");
        String textB = request.getParameter("txtB");
        if (textA == null || textA.trim().length() == 0) {
            out.println("Please enter 'a' value");
            return;
        }
        if (textB == null || textB.trim().length() == 0) {
            out.println("Please enter 'b' value");
            return;
        }
        int a = 0;
        int b = 0;
        try {
            a = Integer.parseInt(textA);
            if (a <= 0) {
                out.println("Must be a integer number!");
                return;
            }
        } catch (Exception e) {
            out.println("Must be a integer number!");
            return;
        }
        
        try {
            b = Integer.parseInt(textB);
            if (b <= 0) {
                out.println("Must be a integer number!");
                return;
            }
        } catch (Exception e) {
            out.println("Must be a integer number!");
            return;
        }
        int result = GCD(a, b);
        out.println("GCD(" + a +","+b+"): "+result);

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
