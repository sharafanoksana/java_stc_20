/**
 * @author Sharafan Oksana
 * @date 05.01.2020
 * @package com.gmail.sharafan
 */
package lesson15.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")

public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("name", "Hello, world!");
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("login");
        String password = req.getParameter("password");
        PrintWriter writer = resp.getWriter();
        if (username.equals("oksana") & password.equals("sharafan")) {
//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/hellopage.jsp");
//            requestDispatcher.forward(req, resp);

            resp.sendRedirect("hellopage");


        } else {
            resp.sendRedirect("MainServlet");
        }
    }
}
