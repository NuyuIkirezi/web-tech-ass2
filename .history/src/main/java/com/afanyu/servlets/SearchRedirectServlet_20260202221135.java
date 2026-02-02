package com.afanyu.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SearchRedirectServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
       
        String searchQuery = request.getParameter("searchQuery");
        
        // URL encode the search query to handle special characters
        String encodedQuery = java.net.URLEncoder.encode(searchQuery, "UTF-8");
        
        // Redirect to Google search with the query
        response.sendRedirect("https://www.google.com/search?q=" + encodedQuery);
    }
}