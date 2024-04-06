/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlet;

import com.dao.DiaDiemDAO;
import com.entites.DiaDiem;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    private DiaDiemDAO diaDiemDAO = new DiaDiemDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchServlet at " + request.getContextPath() + "</h1>");
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

        // Lấy dữ liệu từ form tìm kiếm
        String tenDiaDiem = request.getParameter("diadiem");
        if (tenDiaDiem == null) {
            tenDiaDiem = ""; // Gán là rỗng nếu không có giá trị
        }
        int idDichVu = 0;
        int idGia = 0;
        int idThanhPho = 0;
        int idQuan = 0;
        int idPhuong = 0;

        // Kiểm tra và gán giá trị cho idDichVu
        String dichVuDropdownValue = request.getParameter("dichVuDropdown");
        if (dichVuDropdownValue != null && !dichVuDropdownValue.isEmpty()) {
            idDichVu = Integer.parseInt(dichVuDropdownValue);
        }

        // Kiểm tra và gán giá trị cho idGia
        String giaDropdownValue = request.getParameter("giaDropdown");
        if (giaDropdownValue != null && !giaDropdownValue.isEmpty()) {
            idGia = Integer.parseInt(giaDropdownValue);
        }

        // Kiểm tra và gán giá trị cho idThanhPho
        String thanhPhoDropdownValue = request.getParameter("thanhPhoDropdown");
        if (thanhPhoDropdownValue != null && !thanhPhoDropdownValue.isEmpty()) {
            idThanhPho = Integer.parseInt(thanhPhoDropdownValue);
        }

        // Kiểm tra và gán giá trị cho idQuan
        String quanDropdownValue = request.getParameter("quanDropdown");
        if (quanDropdownValue != null && !quanDropdownValue.isEmpty()) {
            idQuan = Integer.parseInt(quanDropdownValue);
        }

        // Kiểm tra và gán giá trị cho idPhuong
        String phuongDropdownValue = request.getParameter("phuongDropdown");
        if (phuongDropdownValue != null && !phuongDropdownValue.isEmpty()) {
            idPhuong = Integer.parseInt(phuongDropdownValue);
        }

//        // Lấy dữ liệu từ form tìm kiếm
//        String tenDiaDiem = request.getParameter("diadiem");
//        int idDichVu = Integer.parseInt(request.getParameter("dichVuDropdown"));
//        int idGia = Integer.parseInt(request.getParameter("giaDropdown"));
//        int idThanhPho = Integer.parseInt(request.getParameter("thanhPhoDropdown"));
//        int idQuan = Integer.parseInt(request.getParameter("quanDropdown"));
//        int idPhuong = Integer.parseInt(request.getParameter("phuongDropdown"));


        // Gọi phương thức SearchDiaDiem từ một đối tượng (DAO hoặc Service)
        List<DiaDiem> diaDiemList = diaDiemDAO.SearchDiaDiem(tenDiaDiem, idDichVu, idGia, idPhuong, idQuan, idThanhPho);
        // Chuyển kết quả tìm kiếm sang trang search.jsp để hiển thị
        request.setAttribute("diaDiemList", diaDiemList);
        System.out.println(diaDiemList);
        request.getRequestDispatcher("searchResult.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
