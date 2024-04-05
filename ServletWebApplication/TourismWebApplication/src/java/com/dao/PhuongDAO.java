/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.entites.Phuong;
import com.entites.Quan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class PhuongDAO implements IPhuongDAO {

    private Connection con = null;

    public PhuongDAO() {
        this.con = (Connection) DatabaseUtil.getConnect();
    }

    @Override
    public List<Phuong> getAll() {
        List<Phuong> data = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT Phuong.Id, Phuong.TenPhuong, Phuong.IdQuan, Quan.TenQuan "
                    + "FROM Phuong "
                    + "JOIN Quan ON Phuong.IdQuan = Quan.Id");
            while (rs.next()) {
                Phuong phuong = new Phuong();
                phuong.setId(rs.getInt("Id"));
                phuong.setTenPhuong(rs.getString("TenPhuong"));
                phuong.setIdQuan(rs.getInt("IdQuan"));

                Quan quan = new Quan();
                quan.setTenQuan(rs.getString("TenQuan"));
                phuong.setQuan(quan);

                data.add(phuong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public List<Phuong> getWardtNamesByDistrictId(int idQuan) {
        List<Phuong> wardList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Phuong WHERE IdQuan = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setInt(1, idQuan);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("Id");
                        String tenPhuong = resultSet.getString("TenPhuong");
                        // Tạo một đối tượng Phuong và thêm vào danh sách
                        Phuong phuong = new Phuong(id, tenPhuong, idQuan);
                        wardList.add(phuong);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return wardList;
    }

}
