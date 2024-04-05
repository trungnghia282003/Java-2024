/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.entites.Phuong;
import com.entites.Quan;
import com.entites.ThanhPho;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class QuanDAO implements IQuanDAO {

    private Connection con;

    public QuanDAO() {
        this.con = (Connection) DatabaseUtil.getConnect();
    }

    @Override
public List<Quan> getAll() {
    List<Quan> data = new ArrayList<>();
    try {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT Quan.Id, Quan.TenQuan, Quan.IdThanhPho, ThanhPho.TenThanhPho " +
                                       "FROM Quan " +
                                       "JOIN ThanhPho ON Quan.IdThanhPho = ThanhPho.Id");
        while (rs.next()) {
            Quan quan = new Quan();
            quan.setId(rs.getInt("Id"));
            quan.setTenQuan(rs.getString("TenQuan"));
            quan.setIdThanhPho(rs.getInt("IdThanhPho"));
            
            ThanhPho thanhPho = new ThanhPho();
            thanhPho.setTenThanhPho(rs.getString("TenThanhPho"));
            quan.setThanhPho(thanhPho);
            
            data.add(quan);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return data;
}


    public List<Quan> getDistrictNamesByCityId(int idThanhPho) {
    List<Quan> districtList = new ArrayList<>();

    try {
        String sql = "SELECT * FROM Quan WHERE IdThanhPho = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setInt(1, idThanhPho);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("Id");
                    String tenQuan = resultSet.getString("TenQuan");
                    // Tạo một đối tượng Quan và thêm vào danh sách
                    Quan quan = new Quan(id, tenQuan, idThanhPho);
                    districtList.add(quan);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return districtList;
}

}
