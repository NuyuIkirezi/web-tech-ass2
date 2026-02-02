import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Get parameters from the form
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // HTML page styling
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("    <title>Login Response</title>");
        out.println("    <script src='https://cdn.tailwindcss.com'></script>");
        out.println("    <link href='https://fonts.googleapis.com/css2?family=Playfair+Display:wght@700&family=Work+Sans:wght@400;500;600&display=swap' rel='stylesheet'>");
        out.println("    <style>");
        out.println("        body { font-family: 'Work Sans', sans-serif; }");
        out.println("        h1 { font-family: 'Playfair Display', serif; }");
        out.println("    </style>");
        out.println("</head>");
        out.println("<body class='min-h-screen bg-gradient-to-br from-pink-50 via-purple-50 to-blue-50 flex items-center justify-center p-6'>");
        
        out.println("    <div class='w-full max-w-lg'>");
        out.println("        <div class='bg-white/80 backdrop-blur-xl rounded-3xl shadow-2xl p-10 text-center'>");
        
        // Check password length and display appropriate message
        if (password.length() < 8) {
            // Weak password
            out.println("            <div class='inline-flex items-center justify-center w-20 h-20 bg-gradient-to-br from-orange-400 to-red-500 rounded-full mb-6 shadow-lg'>");
            out.println("                <svg class='w-10 h-10 text-white' fill='none' stroke='currentColor' viewBox='0 0 24 24'>");
            out.println("                    <path stroke-linecap='round' stroke-linejoin='round' stroke-width='2' d='M12 9v2m0 4h.01m-6.938 4h13.856c1.54 0 2.502-1.667 1.732-3L13.732 4c-.77-1.333-2.694-1.333-3.464 0L3.34 16c-.77 1.333.192 3 1.732 3z'/>");
            out.println("                </svg>");
            out.println("            </div>");
            out.println("            <h1 class='text-4xl font-bold text-gray-800 mb-4'>Weak Password!</h1>");
            out.println("            <div class='bg-orange-50 border-2 border-orange-200 rounded-2xl p-6 mb-6'>");
            out.println("                <p class='text-lg text-gray-700'>");
            out.println("                    Hello <span class='font-semibold text-orange-600'>" + username + "</span>, your password is weak. Try a strong one.");
            out.println("                </p>");
            out.println("            </div>");
            out.println("            <div class='text-sm text-gray-600 bg-gray-50 rounded-xl p-4'>");
            out.println("                <p class='font-medium mb-2'>Tips for a strong password:</p>");
            out.println("                <ul class='text-left space-y-1 ml-4'>");
            out.println("                    <li>✓ At least 8 characters long</li>");
            out.println("                    <li>✓ Mix of uppercase and lowercase letters</li>");
            out.println("                    <li>✓ Include numbers and special characters</li>");
            out.println("                </ul>");
            out.println("            </div>");
        } else {
            // Strong password - successful login
            out.println("            <div class='inline-flex items-center justify-center w-20 h-20 bg-gradient-to-br from-green-400 to-emerald-500 rounded-full mb-6 shadow-lg'>");
            out.println("                <svg class='w-10 h-10 text-white' fill='none' stroke='currentColor' viewBox='0 0 24 24'>");
            out.println("                    <path stroke-linecap='round' stroke-linejoin='round' stroke-width='2' d='M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z'/>");
            out.println("                </svg>");
            out.println("            </div>");
            out.println("            <h1 class='text-4xl font-bold text-gray-800 mb-4'>Welcome!</h1>");
            out.println("            <div class='bg-green-50 border-2 border-green-200 rounded-2xl p-6 mb-6'>");
            out.println("                <p class='text-xl text-gray-700'>");
            out.println("                    Welcome <span class='font-bold text-green-600'>" + username + "</span>");
            out.println("                </p>");
            out.println("            </div>");
            out.println("            <p class='text-gray-600'>You have successfully logged in!</p>");
        }
        
        // Back button
        out.println("            <div class='mt-8'>");
        out.println("                <a href='assignment1-login.html' class='inline-block bg-gradient-to-r from-pink-500 to-purple-600 text-white font-semibold py-3 px-8 rounded-xl shadow-lg hover:shadow-xl hover:from-pink-600 hover:to-purple-700 transform transition-all duration-200 hover:scale-105'>");
        out.println("                    Back to Login");
        out.println("                </a>");
        out.println("            </div>");
        
        out.println("        </div>");
        out.println("    </div>");
        
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
}