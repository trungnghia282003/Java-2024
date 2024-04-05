/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.entites.DiaDiem;
import com.entites.DichVu;
import com.entites.Gia;
import com.entites.Phuong;
import com.entites.Quan;
import com.entites.ThanhPho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class DiaDiemDAO implements IDiaDiemDAO {

    private Connection con = null;

    public DiaDiemDAO() {
        this.con = (Connection) DatabaseUtil.getConnect();
    }

    // Hàm GetAll để lấy thông tin từ các bảng và trả về danh sách DiaDiem
    @Override
    public List<DiaDiem> GetAll() {
        List<DiaDiem> data = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            String query = "SELECT DiaDiem.Id, DiaDiem.TenDiaDiem, DiaDiem.IdDichVu, DiaDiem.IdGia, DiaDiem.IdPhuong, "
                    + "DichVu.TenDichVu, Gia.MucGia, Phuong.TenPhuong, Quan.TenQuan, ThanhPho.TenThanhPho "
                    + "FROM DiaDiem "
                    + "JOIN DichVu ON DiaDiem.IdDichVu = DichVu.Id "
                    + "JOIN Gia ON DiaDiem.IdGia = Gia.Id "
                    + "JOIN Phuong ON DiaDiem.IdPhuong = Phuong.Id "
                    + "JOIN Quan ON Phuong.IdQuan = Quan.Id "
                    + "JOIN ThanhPho ON Quan.IdThanhPho = ThanhPho.Id";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                DiaDiem diaDiem = new DiaDiem();
                diaDiem.setId(rs.getInt("Id"));
                diaDiem.setTenDiaDiem(rs.getString("TenDiaDiem"));
                diaDiem.setIdDichVu(rs.getInt("IdDichVu"));
                diaDiem.setIdGia(rs.getInt("IdGia"));
                diaDiem.setIdPhuong(rs.getInt("IdPhuong"));

                DichVu dichVu = new DichVu();
                dichVu.setTenDichVu(rs.getString("TenDichVu"));
                diaDiem.setDichVu(dichVu);

                Gia gia = new Gia();
                gia.setMucGia(rs.getString("MucGia"));
                diaDiem.setGia(gia);

                Phuong phuong = new Phuong();
                phuong.setTenPhuong(rs.getString("TenPhuong"));
                Quan quan = new Quan();
                quan.setTenQuan(rs.getString("TenQuan"));
                ThanhPho thanhPho = new ThanhPho();
                thanhPho.setTenThanhPho(rs.getString("TenThanhPho"));
                quan.setThanhPho(thanhPho);
                phuong.setQuan(quan);

                diaDiem.setPhuong(phuong);

                data.add(diaDiem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public List<DiaDiem> SearchDiaDiem(String tenDiaDiem, int idDichVu, int idGia, int idPhuong, int idQuan, int idThanhPho) {
        List<DiaDiem> diaDiemList = new ArrayList<>();
        try {
            StringBuilder sqlBuilder = new StringBuilder("SELECT DiaDiem.Id, DiaDiem.TenDiaDiem, DiaDiem.IdDichVu, DiaDiem.IdGia, DiaDiem.IdPhuong,")
                    .append("DichVu.TenDichVu, Gia.MucGia, Phuong.TenPhuong, Quan.Id AS IdQuan, ThanhPho.Id AS IdThanhPho, ")
                    .append("ThanhPho.TenThanhPho, Quan.TenQuan ")
                    .append("FROM DiaDiem ")
                    .append("JOIN DichVu ON DiaDiem.IdDichVu = DichVu.Id ")
                    .append("JOIN Gia ON DiaDiem.IdGia = Gia.Id ")
                    .append("JOIN Phuong ON DiaDiem.IdPhuong = Phuong.Id ")
                    .append("JOIN Quan ON Phuong.IdQuan = Quan.Id ")
                    .append("JOIN ThanhPho ON Quan.IdThanhPho = ThanhPho.Id ")
                    .append("WHERE 1=1");

            // Thêm điều kiện tìm kiếm cho tên địa điểm
            if (!tenDiaDiem.isEmpty()) {
                sqlBuilder.append(" AND DiaDiem.TenDiaDiem LIKE ?");
            }

            // Thêm điều kiện tìm kiếm cho idDichVu
            if (idDichVu != 0) {
                sqlBuilder.append(" AND DiaDiem.IdDichVu = ?");
            }

            // Thêm điều kiện tìm kiếm cho idGia
            if (idGia != 0) {
                sqlBuilder.append(" AND DiaDiem.IdGia = ?");
            }

            // Thêm điều kiện tìm kiếm cho idPhuong
            if (idPhuong != 0) {
                sqlBuilder.append(" AND DiaDiem.IdPhuong = ?");
            }

            // Thêm điều kiện tìm kiếm cho idQuan
            if (idQuan != 0) {
                sqlBuilder.append(" AND Quan.Id = ?");
            }

            // Thêm điều kiện tìm kiếm cho idThanhPho
            if (idThanhPho != 0) {
                sqlBuilder.append(" AND ThanhPho.Id = ?");
            }

            PreparedStatement preparedStatement = con.prepareStatement(sqlBuilder.toString());
            int parameterIndex = 1;

            // Thiết lập các tham số cho điều kiện tìm kiếm
            if (!tenDiaDiem.isEmpty()) {
                preparedStatement.setString(parameterIndex++, "%" + tenDiaDiem + "%");
            }
            if (idDichVu != 0) {
                preparedStatement.setInt(parameterIndex++, idDichVu);
            }
            if (idGia != 0) {
                preparedStatement.setInt(parameterIndex++, idGia);
            }
            if (idPhuong != 0) {
                preparedStatement.setInt(parameterIndex++, idPhuong);
            }
            if (idQuan != 0) {
                preparedStatement.setInt(parameterIndex++, idQuan);
            }
            if (idThanhPho != 0) {
                preparedStatement.setInt(parameterIndex++, idThanhPho);
            }

            // Thực thi câu truy vấn
            ResultSet resultSet = preparedStatement.executeQuery();

            // Đọc kết quả và thêm vào danh sách DiaDiem         
            while (resultSet.next()) {
                // Tạo các đối tượng DiaDiem từ dữ liệu của mỗi dòng kết quả
                DiaDiem diaDiem = new DiaDiem(
                        resultSet.getInt("Id"),
                        resultSet.getString("TenDiaDiem"),
                        resultSet.getInt("IdDichVu"),
                        resultSet.getInt("IdGia"),
                        resultSet.getInt("IdPhuong"),
                        new DichVu(resultSet.getInt("IdDichVu"), resultSet.getString("TenDichVu")),
                        new Gia(resultSet.getInt("IdGia"), resultSet.getString("MucGia")),
                        new Phuong(resultSet.getInt("IdPhuong"), resultSet.getString("TenPhuong")),
                        new Quan(resultSet.getInt("IdQuan"), resultSet.getString("TenQuan")),
                        new ThanhPho(resultSet.getInt("IdThanhPho"), resultSet.getString("TenThanhPho"))
                );
                // Thêm DiaDiem vào danh sách
                diaDiemList.add(diaDiem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diaDiemList;
    }

}
