package com.example.lab_06;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));

        HttpSession session = req.getSession();
        List<User> users = (List<User>) session.getAttribute("users");
        if(users == null) users = new ArrayList<>();

        users.add(new User(name, age));
        session.setAttribute("users", users);

        resp.sendRedirect("user"); // Chuyển hướng đến doGet
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/users.jsp").forward(req, resp);
    }
}
