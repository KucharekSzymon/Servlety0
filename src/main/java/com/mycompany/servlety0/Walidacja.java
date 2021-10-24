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
 * @author Main-PC
 */
public class Walidacja extends HttpServlet {

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
            String name = request.getParameter("name");
            String pesel = request.getParameter("pesel");
            String bdate = request.getParameter("bdate");
            String sex = request.getParameter("sex");
            String profession = request.getParameter("profession");
            String email = request.getParameter("email");
            String height = request.getParameter("height");
            String hobby = request.getParameter("hobby");

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Walidacja</title>");            
            out.println("</head>");
            out.println("<body style='background-color: lightgray'>");

            //Name

            Pattern pn = Pattern.compile("^[a-zA-Z'-]+$");
            Matcher mn = pn.matcher(name);
            if(mn.matches())    out.println("<p>Name: "+name);
            else    out.println("<p style='color:red'>Incorrect name!");

            //Pesel

            Pattern pp = Pattern.compile("^\\d{11}");
            Matcher mp = pp.matcher(pesel);
            if(mp.matches())    out.println("<p>Pesel: "+pesel);
            else    out.println("<p style='color:red'>Incorrect pesel!");

            //BDate

            Pattern pbd = Pattern.compile("^(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$");
            Matcher mbd = pbd.matcher(bdate);
            if(mbd.matches())    out.println("<p>Brth Date: "+bdate);
            else    out.println("<p style='color:red'>Incorrect Brth Date!");

            //Sex

            Pattern ps = Pattern.compile("^\\bMale\\b|\\bFemale\\b|\\bOther\\b");
            Matcher ms = ps.matcher(sex);
            if(ms.matches())    out.println("<p>Sex: "+sex);
            else    out.println("<p style='color:red'>Incorrect sex!");

            //Profession

            Pattern pps = Pattern.compile("^[A-Z]\\w*$");
            Matcher mps = pps.matcher(profession);
            if(mps.matches())    out.println("<p>Profession: "+profession);
            else    out.println("<p style='color:red'>Incorrect profession!");

            //Email

            Pattern pem = Pattern.compile("^(.+)@(.+)$");
            Matcher mem = pem.matcher(email);
            if(mem.matches())    out.println("<p>Email: "+email);
            else    out.println("<p style='color:red'>Incorrect email!");

            //Height

            Pattern phee = Pattern.compile("^\\d{3}");
            Matcher mhee = phee.matcher(height);
            if(mhee.matches())    out.println("<p>Height: "+height);
            else    out.println("<p style='color:red'>Incorrect height!");

            //Hobby

            Pattern phbb = Pattern.compile("^[A-Z]\\w*$");
            Matcher mhbb = phbb.matcher(hobby);
            if(mhbb.matches())    out.println("<p>Hobby: "+hobby);
            else    out.println("<p style='color:red'>Incorrect hobby!");

            out.println("<br><a href='/Servlety0/'>&#8592 Strona główna</a>");
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
