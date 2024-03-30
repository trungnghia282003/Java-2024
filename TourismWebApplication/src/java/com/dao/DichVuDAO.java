/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.entites.DichVu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class DichVuDAO implements IDichVuDAO {

    private Connection con = null;

    public DichVuDAO() {
        this.con = (Connection) DatabaseUtil.getConnect();
    }

    @Override
    public List<DichVu> getAll() {
        List<DichVu> data = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from DichVu");
            while (rs.next()) {
                DichVu f = new DichVu(rs.getInt("Id"), rs.getString("TenDichVu"));
                data.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

//    public static void main(String[] args) {
//        // Call your getAll() method here
//        DichVuDAO myInstance = new DichVuDAO();
//        List<DichVu> dichVuList = myInstance.getAll();
//        for (DichVu dichVu : dichVuList) {
//            System.out.println("DichVu ID: " + dichVu.getId() + ", TenDichVu: " + dichVu.getTenDichVu());
//        }
//    }
}
