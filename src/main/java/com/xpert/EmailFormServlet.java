
package com.xpert;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet(name = "EmailFormServlet", urlPatterns = {"/EmailFormServlet"})
public class EmailFormServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("EmailFormServlet GET called");

        request.getRequestDispatcher("/WEB-INF/JSP/emailForm.jsp").forward(request, response);
               
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        request.getRequestDispatcher("/sendMail")
               .forward(request, response);
    }
}
