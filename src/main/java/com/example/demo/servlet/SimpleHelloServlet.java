package com.example.demo.servlet;

import jakarta.servlet.http.*;
import java.io.IOException;

public class SimpleHelloServlet extends HttpServlet {
    @Override
    
public void doGet(...)(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write("Hello from Servlet");
    }

    @Override
    public String getServletInfo(){
        return "SimpleHelloServlet";
    }
}
