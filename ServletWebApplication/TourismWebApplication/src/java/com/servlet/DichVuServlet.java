/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlet;

import com.dao.DiaDiemDAO;
import com.dao.DichVuDAO;
import com.dao.GiaDAO;
import com.dao.PhuongDAO;
import com.dao.QuanDAO;
import com.dao.ThanhPhoDAO;
import com.entites.DiaDiem;
import com.entites.DichVu;
import com.entites.Gia;
import com.entites.Phuong;
import com.entites.Quan;
import com.entites.ThanhPho;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author ASUS
 */
@WebServlet("/dulichvietnam")
public class DichVuServlet extends HttpServlet {

    private DichVuDAO dichVuDAO = new DichVuDAO();
    private GiaDAO giaDAO = new GiaDAO();
    private ThanhPhoDAO thanhPhoDAO = new ThanhPhoDAO();
    private QuanDAO quanDAO = new QuanDAO();
    private PhuongDAO phuongDAO = new PhuongDAO();
    private DiaDiemDAO diaDiemDAO = new DiaDiemDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DichVuServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DichVuServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<DichVu> dichVuList = dichVuDAO.getAll();
        request.setAttribute("dichVuList", dichVuList);

        List<Gia> giaList = giaDAO.getAll();
        request.setAttribute("giaList", giaList);

        List<ThanhPho> thanhPhoList = thanhPhoDAO.getAll();
        request.setAttribute("thanhPhoList", thanhPhoList);

        List<Quan> quanList = quanDAO.getAll();
        request.setAttribute("quanList", quanList);
      
        List<Phuong> phuongList = phuongDAO.getAll();
        request.setAttribute("phuongList", phuongList);
        String action = request.getParameter("action");

        if (action != null) {
            if (action.equals("getDistrictsByCityId")) {
                String cityId = request.getParameter("cityId");
                if (cityId != null && !cityId.isEmpty()) {
                    // Gọi hàm getDistrictNamesByCityId từ DAO để lấy danh sách các Quận của Thành phố và đặt vào request attribute
                    List<Quan> quanListDropdown = quanDAO.getDistrictNamesByCityId(Integer.parseInt(cityId));
                    request.setAttribute("quanList", quanList);

                    // Gửi danh sách Quận nhận được dưới dạng HTML trở lại trang JSP
                    response.setContentType("text/html");
                    PrintWriter out = response.getWriter();
                    for (Quan quan : quanListDropdown) {
                        out.println("<option value=\"" + quan.getId() + "\">" + quan.getTenQuan() + "</option>");
                    }
                    out.close();
                }
            } else if (action.equals("getWardsByDistrictId")) {
                String districtId = request.getParameter("districtId");
                if (districtId != null && !districtId.isEmpty()) {
                    // Gọi hàm getWardNamesByDistrictId từ DAO để lấy danh sách các Phường của Quận và đặt vào request attribute
                    List<Phuong> phuongListDropdown = phuongDAO.getWardtNamesByDistrictId(Integer.parseInt(districtId));
                    request.setAttribute("phuongList", phuongList);

                    // Gửi danh sách Phường nhận được dưới dạng HTML trở lại trang JSP
                    response.setContentType("text/html");
                    PrintWriter out = response.getWriter();
                    for (Phuong phuong : phuongListDropdown) {
                        out.println("<option value=\"" + phuong.getId() + "\">" + phuong.getTenPhuong() + "</option>");
                    }
                    out.close();
                }
            }
        }

        List<DiaDiem> diaDiemList = diaDiemDAO.GetAll();
        request.setAttribute("diaDiemList", diaDiemList);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

// Phương thức hỗ trợ để chuyển đổi chuỗi thành số nguyên và xử lý trường hợp null
    private int parseIntParameter(String param) {
        return param != null ? Integer.parseInt(param) : 0;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
