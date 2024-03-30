/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entites;

/**
 *
 * @author ASUS
 */
public class Quan {
    
    private int id;
    private String tenQuan;
    private int idPhuong;

    public Quan() {
    }

    public Quan(int id, String tenQuan, int idPhuong) {
        this.id = id;
        this.tenQuan = tenQuan;
        this.idPhuong = idPhuong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenQuan() {
        return tenQuan;
    }

    public void setTenQuan(String tenQuan) {
        this.tenQuan = tenQuan;
    }

    public int getIdPhuong() {
        return idPhuong;
    }

    public void setIdPhuong(int idPhuong) {
        this.idPhuong = idPhuong;
    }
    
    
}
