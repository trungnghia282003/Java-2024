/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dao;

import com.entites.DichVu;
import com.entites.Phuong;
import java.util.List;

public interface IPhuongDAO {
     public List<Phuong> getAll();
     public List<Phuong> getWardtNamesByDistrictId(int idQuan);
}
