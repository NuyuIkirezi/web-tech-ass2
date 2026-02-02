package com.afanyu.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        out.println("<html>");
        out.println("<head><title>Login Response</title></head>");
        out.println("<body>");
        out.println("<h1>Login Result</h1>");
        
        if (password.length() < 8) {
            out.println("<p>Hello " + username + ", your password is weak. Try a strong one.</p>");
            out.println("<p>Password must be at least 8 characters long.</p>");
        } else {
            out.println("<p>Welcome " + username + "!</p>");
            out.println("<p>You have successfully logged in.</p>");
        }
        
        out.println("<br>");
        out.println("<a href='assignment1-login.html'>Try Again</a>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
}