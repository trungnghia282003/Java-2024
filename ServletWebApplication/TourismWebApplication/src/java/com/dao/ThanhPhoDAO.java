/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.entites.Quan;
import com.entites.ThanhPho;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ThanhPhoDAO implements IThanhPhoDAO {

    private Connection con = null;

    public ThanhPhoDAO() {
        this.con = (Connection) DatabaseUtil.getConnect();
    }

    @Override
    public List<ThanhPho> getAll() {
        List<ThanhPho> data = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from ThanhPho");
            while (rs.next()) {
                ThanhPho f = new ThanhPho(rs.getInt("Id"), rs.getString("TenThanhPho"));
                data.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
}
