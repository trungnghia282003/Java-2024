/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quanlidulichvietnam.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "RestaurantTable")
public class RestaurantTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "NVARCHAR(255)", nullable = false)
    private String tableName;

    @Column(nullable = false)
    private int numberSeats;

    @Column(columnDefinition = "BIT", nullable = false)
    private byte status;

    @ManyToOne
    @JoinColumn(name = "table_area_id", nullable = false)
    private TableArea tableArea;

    public RestaurantTable(String tableName, int numberSeats, byte status, TableArea tableArea) {
        this.tableName = tableName;
        this.numberSeats = numberSeats;
        this.status = status;
        this.tableArea = tableArea;
    }

}
