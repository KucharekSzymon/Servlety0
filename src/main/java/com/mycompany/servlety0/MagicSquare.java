/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlety0;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Laptop
 */
public class MagicSquare extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            Integer[][] magicSquare = new Integer[5][5];
            for (int i = 0;i<5;i++){
                for(int j = 0;j<5;j++) {
                    String temp = "t"+i+j;
                    magicSquare[i][j] = Integer.parseInt(request.getParameter(temp));
                }
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Magiczny kwadrat</title>");
            out.println("</head>");
            out.println("<body style='background-color: lightgray'>");
            Integer osi = 0,osj = 0,przekatna = 0;
            for (int i = 0;i<5;i++){
                for(int j = 0;j<5;j++) {
                    if(i == 0) osi += magicSquare[i][j];
                    if(j == 0) osj += magicSquare[i][j];
                    if(i == j) przekatna += magicSquare[i][j];
                    out.println(magicSquare[i][j]);
                }
                out.println("<br> ");

            }
            if(osi == osj && osi == przekatna && przekatna == osj){
                out.println("<p style='color:red;'>Kwadrat jest magiczny!</p>");
            }
            out.println("<p>Suma osi X: "+osi+"</p>");
            out.println("<p>Suma osi Y: "+osj+"</p>");
            out.println("<p>Suma przekatnej: "+przekatna +"</p>");

            out.println("</body>");
            out.println("</html>");
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
