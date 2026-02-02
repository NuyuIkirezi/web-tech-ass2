import java.io.*;
import java.net.URLEncoder;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/SearchRedirectServlet")
public class SearchRedirectServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Get the search query parameter from the form
        String searchQuery = request.getParameter("searchQuery");
        
        // Check if search query is not null or empty
        if (searchQuery != null && !searchQuery.trim().isEmpty()) {
            // Encode the search query to make it URL-safe
            String encodedQuery = URLEncoder.encode(searchQuery, "UTF-8");
            
            // Create the Google search URL with the query
            String googleSearchURL = "https://www.google.com/search?q=" + encodedQuery;
            
            // Use sendRedirect to redirect the user to Google search
            response.sendRedirect(googleSearchURL);
        } else {
            // If query is empty, redirect back to the search page
            response.sendRedirect("assignment2-search.html");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Handle GET requests by redirecting to the search page
        response.sendRedirect("assignment2-search.html");
    }
}