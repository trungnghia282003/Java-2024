/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entites;

/**
 *
 * @author ASUS
 */
public class DichVu {

    private int id;
    private String tenDichVu;

    public DichVu() {
    }

    public DichVu(int id, String tenDichVu) {
        this.id = id;
        this.tenDichVu = tenDichVu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

}
