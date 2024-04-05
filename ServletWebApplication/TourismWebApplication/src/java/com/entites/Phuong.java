/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entites;

/**
 *
 * @author ASUS
 */
    public class Phuong {

        private int id;
        private String tenPhuong;
        private int idQuan;
        private Quan quan;

    public Phuong() {
    }
    
    public Phuong(int id, String tenPhuong, int idQuan) {
        this.id = id;
        this.tenPhuong = tenPhuong;
        this.idQuan = idQuan;
    }

    public Phuong(int id, String tenPhuong, int idQuan, Quan quan) {
        this.id = id;
        this.tenPhuong = tenPhuong;
        this.idQuan = idQuan;
        this.quan = quan;
    }

    public Phuong(int idPhuong, String tenPhuong) {
         this.id = id;
        this.tenPhuong = tenPhuong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenPhuong() {
        return tenPhuong;
    }

    public void setTenPhuong(String tenPhuong) {
        this.tenPhuong = tenPhuong;
    }

    public int getIdQuan() {
        return idQuan;
    }

    public void setIdQuan(int idQuan) {
        this.idQuan = idQuan;
    }

    public Quan getQuan() {
        return quan;
    }

    public void setQuan(Quan quan) {
        this.quan = quan;
    }
  
}
