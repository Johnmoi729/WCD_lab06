package com.example.lab_06;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/include")
public class IncludeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String message = req.getParameter("message");
        req.setAttribute("message", message != null ? message : "Chào mừng!");
        resp.setContentType("text/html; charset=UTF-8");

        // Include header
        RequestDispatcher headerDispatcher = req.getRequestDispatcher("/header-greeting.jsp");
        headerDispatcher.include(req, resp);

        // Include welcome page
        RequestDispatcher mainDispatcher = req.getRequestDispatcher("/welcome.jsp");
        mainDispatcher.include(req, resp);
    }
}
