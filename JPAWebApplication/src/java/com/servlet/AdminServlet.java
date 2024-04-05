/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlet;

import com.dao.UserDAO;
import com.entites.Users;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /*  output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Gọi phương thức getAll của UserDAO để lấy danh sách tất cả người dùng
        UserDAO userDAO = new UserDAO();
        List<Users> userList = userDAO.getAll();

        // Đặt danh sách người dùng là một thuộc tính của yêu cầu
        request.setAttribute("userList", userList);

        // Chuyển hướng yêu cầu đến trang JSP admin.jsp
        request.getRequestDispatcher("admin.jsp").forward(request, response);

        String action = request.getParameter("action");
        try {
            switch (action) {
                case "/showEdit":
                    showEdit(request, response);
                    break;

            }
        } catch (Exception ex) {

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try {
            switch (action) {
                case "/insert":
                    insert(request, response);
                    break;
                case "/update":
                    update(request, response);
                    break;
                case "/delete":
                    delete(request, response);
                    break;
                default:
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                    dispatcher.forward(request, response);
                    break;
            }
        } catch (Exception ex) {

        }
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Thực hiện chức năng insert
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int roleId = 2; // Gắn mặc định roleId là 2

        // Kiểm tra xem username và password có được nhập đầy đủ hay không
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            // Nếu có bất kỳ trường nào không được nhập đầy đủ, in ra thông báo và không thực hiện thêm mới người dùng
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('Please enter both username and password.');");
            out.println("setTimeout(function() { window.location.href = 'admin'; });"); // Chuyển hướng sau 1 giây
            out.println("</script>");
            return;
        }

        // Tạo đối tượng User từ thông tin lấy được
        Users newUser = new Users(username, password, roleId);

        // Gọi phương thức insert trong UserDAO để thêm mới người dùng vào cơ sở dữ liệu
        UserDAO userDAO = new UserDAO();
        int result = userDAO.Insert(newUser);

        if (result == 1) {
            // Thêm mới thành công
            response.sendRedirect("admin"); // Chuyển hướng về trang admin
        } else {
            // Thêm mới thất bại
            response.sendRedirect("error"); // Chuyển hướng về trang thông báo lỗi
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy id của người dùng từ request
        int userId = Integer.parseInt(request.getParameter("userId"));

        // Gọi hàm getUserById để lấy thông tin người dùng từ UserDAO
        UserDAO userDAO = new UserDAO();
        Users user = userDAO.getUserById(userId);

        // Đưa thông tin người dùng vào attribute của request để hiển thị lên modal
        request.setAttribute("user", user);

        // Chuyển hướng request tới trang cập nhật thông tin người dùng
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin");
        dispatcher.forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve updated user information from request parameters
        int userId = Integer.parseInt(request.getParameter("editUserId"));
        String username = request.getParameter("editUsername");
        String password = request.getParameter("editPassword");
        
        // Kiểm tra xem username và password có được nhập đầy đủ hay không
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            // Nếu có bất kỳ trường nào không được nhập đầy đủ, in ra thông báo và không thực hiện thêm mới người dùng
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('Please enter both username and password.');");
            out.println("setTimeout(function() { window.location.href = 'admin'; });"); // Chuyển hướng sau 1 giây
            out.println("</script>");
            return;
        }

        // Create a Users object with updated information
        Users updatedUser = new Users(userId, username, password);

        // Call the Update method of your UserDAO class
        UserDAO userDAO = new UserDAO();
        int result = userDAO.Update(updatedUser);

        if (result == 1) {
            // Update successful
            response.sendRedirect("admin"); // Redirect to admin page or another appropriate page
        } else if (result == -1) {
            // User with provided ID not found
            response.sendRedirect("error"); // Redirect to error page or display an error message
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy userId từ request parameter
        int userId = Integer.parseInt(request.getParameter("deleteUserId"));

        // Gọi phương thức Delete trong UserDAO để xóa người dùng
        UserDAO userDAO = new UserDAO();
        int result = userDAO.Delete(userId);

        // Xử lý kết quả xóa
        if (result == 1) {
            // Xóa thành công, chuyển hướng về trang admin hoặc trang khác
            response.sendRedirect("admin");
        } else {
            // Xóa thất bại, chuyển hướng về trang thông báo lỗi hoặc hiển thị thông báo lỗi
            response.sendRedirect("error");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
