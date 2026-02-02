package com.afanyu.servlets;

import java.io.IOException;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SearchRedirectServlet")
public class SearchRedirectServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Get search query from form
        String searchQuery = request.getParameter("searchQuery");
        
        // Check if query is valid
        if (searchQuery != null && !searchQuery.trim().isEmpty()) {
            // Encode the search query for URL
            String encodedQuery = URLEncoder.encode(searchQuery, "UTF-8");
            
            // Create Google search URL
            String googleSearchURL = "https://www.google.com/search?q=" + encodedQuery;
            
            // Redirect to Google search
            response.sendRedirect(googleSearchURL);
        } else {
            // If empty, redirect back to search page
            response.sendRedirect("assignment2-search.html");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Redirect GET requests to the search page
        response.sendRedirect("assignment2-search.html");
    }
}