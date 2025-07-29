package com.example.lab_06;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form parameters
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));

        // Get or create product list in session
        HttpSession session = request.getSession();
        List<Product> products = (List<Product>) session.getAttribute("products");
        if (products == null) {
            products = new ArrayList<>();
        }

        // Add new product
        products.add(new Product(name, price));
        session.setAttribute("products", products);

        // Redirect to display page
        response.sendRedirect("product");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Include header
        RequestDispatcher headerDispatcher = request.getRequestDispatcher("/header.jsp");
        headerDispatcher.include(request, response);

        // Forward to products page
        RequestDispatcher productDispatcher = request.getRequestDispatcher("/products.jsp");
        productDispatcher.forward(request, response);

        // Include footer
        RequestDispatcher footerDispatcher = request.getRequestDispatcher("/footer.jsp");
        footerDispatcher.include(request, response);
    }
}
