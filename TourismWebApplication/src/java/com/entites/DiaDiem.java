/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entites;

/**
 *
 * @author ASUS
 */
public class DiaDiem {

    private int id;
    private String tenDiaDiem;
    private int idDichVu;
    private int idGia;
    private int idThanhPho;

    public DiaDiem() {
    }

    public DiaDiem(int id, String tenDiaDiem, int idDichVu, int idGia, int idThanhPho) {
        this.id = id;
        this.tenDiaDiem = tenDiaDiem;
        this.idDichVu = idDichVu;
        this.idGia = idGia;
        this.idThanhPho = idThanhPho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDiaDiem() {
        return tenDiaDiem;
    }

    public void setTenDiaDiem(String tenDiaDiem) {
        this.tenDiaDiem = tenDiaDiem;
    }

    public int getIdDichVu() {
        return idDichVu;
    }

    public void setIdDichVu(int idDichVu) {
        this.idDichVu = idDichVu;
    }

    public int getIdGia() {
        return idGia;
    }

    public void setIdGia(int idGia) {
        this.idGia = idGia;
    }

    public int getIdThanhPho() {
        return idThanhPho;
    }

    public void setIdThanhPho(int idThanhPho) {
        this.idThanhPho = idThanhPho;
    }

}
