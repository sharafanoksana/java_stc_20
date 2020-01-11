/**
 * @author Sharafan Oksana
 * @date 07.01.2020
 * @package com.gmail.sharafan.servlets
 */
package lesson15.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hellopage")
public class HellopageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("Method GET from IndexServlet");


//        req.setAttribute("name", "Hello, world!");
        req.getRequestDispatcher("hellopage.jsp").forward(req, resp);
    }
}
