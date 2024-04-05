/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dao;

import com.entites.DiaDiem;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IDiaDiemDAO {

    public List<DiaDiem> GetAll();

    public List<DiaDiem> SearchDiaDiem(String tenDiaDiem, int idDichVu, int idGia, int idPhuong, int idQuan, int idThanhPho);
}
