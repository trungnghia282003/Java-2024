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
    private int idThanhPho;
    private ThanhPho thanhPho;

    public Quan() {
    }

    public Quan(String tenQuan) {
        this.tenQuan = tenQuan;
    }

    public Quan(int id, String tenQuan, int idThanhPho) {
        this.id = id;
        this.tenQuan = tenQuan;
        this.idThanhPho = idThanhPho;
    }

    public Quan(int id, String tenQuan, int idThanhPho, ThanhPho thanhPho) {
        this.id = id;
        this.tenQuan = tenQuan;
        this.idThanhPho = idThanhPho;
        this.thanhPho = thanhPho;
    }

    public Quan(int id, String tenQuan) {
        this.id = id;
        this.tenQuan = tenQuan;
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

    public int getIdThanhPho() {
        return idThanhPho;
    }

    public void setIdThanhPho(int idThanhPho) {
        this.idThanhPho = idThanhPho;
    }

    public ThanhPho getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(ThanhPho thanhPho) {
        this.thanhPho = thanhPho;
    }

}
