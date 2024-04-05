/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;


import com.entites.Gia;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class GiaDAO implements IGiaDAO{
    private Connection con = null;

    public GiaDAO() {
        this.con = (Connection) DatabaseUtil.getConnect();
    }
    
    
    @Override
    public List<Gia> getAll() {
        List<Gia> data = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Gia");
            while (rs.next()) {
                Gia f = new Gia(rs.getInt("Id"), rs.getString("MucGia"));
                data.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
}
