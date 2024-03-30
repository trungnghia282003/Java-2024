/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entites;

/**
 *
 * @author ASUS
 */
public class ThanhPho {

    private int id;
    private String tenThanhPho;
    private int idQuan;

    public ThanhPho() {
    }

    public ThanhPho(int id, String tenThanhPho, int idQuan) {
        this.id = id;
        this.tenThanhPho = tenThanhPho;
        this.idQuan = idQuan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenThanhPho() {
        return tenThanhPho;
    }

    public void setTenThanhPho(String tenThanhPho) {
        this.tenThanhPho = tenThanhPho;
    }

    public int getIdQuan() {
        return idQuan;
    }

    public void setIdQuan(int idQuan) {
        this.idQuan = idQuan;
    }

}
