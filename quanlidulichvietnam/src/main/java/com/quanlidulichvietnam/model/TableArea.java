/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quanlidulichvietnam.model;

import jakarta.persistence.*;
import java.util.Set;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "TableArea")
public class TableArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, columnDefinition = "NVARCHAR(50)")
    private String areaName;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @OneToMany(mappedBy = "tableArea")
    private Set<RestaurantTable> restaurantTables;

    public TableArea(String areaName, String description, Restaurant restaurant) {
        this.areaName = areaName;
        this.description = description;
        this.restaurant = restaurant;
    }

}
