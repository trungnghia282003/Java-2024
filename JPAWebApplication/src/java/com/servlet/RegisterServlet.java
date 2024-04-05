/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlet;

import com.dao.UserDAO;
import com.entites.Users;
import com.utils.JpaUtils;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author ASUS
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();

        // Nếu người dùng tồn tại, in ra màn hình người dùng đã tồn tại
        if (userDAO.checkDuplicates(username)) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('User already exists'); setTimeout(function() { window.location.href = 'register.jsp'; }, 1500);</script>");
            return;
        }

        // Nếu người dùng chưa tồn tại, tạo người dùng mới và lưu vào cơ sở dữ liệu
        Users newUser = new Users();

        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setRoleId(2);

        // Thực hiện thêm mới user
        userDAO.Insert(newUser);

        // In ra modal thông báo và chuyển hướng đến trang login
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('User registered successfully'); setTimeout(function() { window.location.href = 'login.jsp'; }, 1500);</script>");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
