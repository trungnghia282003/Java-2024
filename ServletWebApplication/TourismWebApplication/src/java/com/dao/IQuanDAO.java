/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.entites.Quan;
import java.util.List;


public interface  IQuanDAO {
    public List<Quan> getAll();
    public List<Quan> getDistrictNamesByCityId(int idThanhPho);
}
