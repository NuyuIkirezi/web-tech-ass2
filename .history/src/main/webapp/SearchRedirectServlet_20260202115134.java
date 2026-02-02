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
        
       
        String searchQuery = request.getParameter("searchQuery");
        
       
        if (searchQuery != null && !searchQuery.trim().isEmpty()) {
          
            String encodedQuery = URLEncoder.encode(searchQuery, "UTF-8");
            
          
            String googleSearchURL = "https://www.google.com/search?q=" + encodedQuery;
            
           
            response.sendRedirect(googleSearchURL);
        } else {
           
            response.sendRedirect("assignment2-search.html");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.sendRedirect("assignment2-search.html");
    }
}