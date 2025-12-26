package com.example.demo.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class SimpleHelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Hello from SimpleHelloServlet!");
    }
}
