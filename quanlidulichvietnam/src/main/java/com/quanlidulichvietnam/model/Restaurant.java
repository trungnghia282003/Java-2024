/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quanlidulichvietnam.model;

import jakarta.persistence.*;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, columnDefinition = "NVARCHAR(255)")
    private String restaurantName;

    @Column(nullable = false, columnDefinition = "NVARCHAR(50)")
    private String phone;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TIME", nullable = false)
    private LocalTime openingHours;

    @Column(columnDefinition = "TIME", nullable = false)
    private LocalTime closingHours;

    @Column(nullable = false, columnDefinition = "BIT")
    private byte status;

    @ManyToOne
    @JoinColumn(name = "ward_id", nullable = false)
    private Ward ward;

    @OneToMany(mappedBy = "restaurant")
    private Set<RestaurantImage> restaurantImages;
    
    @OneToMany(mappedBy = "restaurant")
    private Set<TableArea> tableAreas;
    
    @OneToMany(mappedBy = "restaurant")
    private Set<Dish> dishes;

    public Restaurant(String restaurantName, String phone, String description, LocalTime openingHours, LocalTime closingHours, byte status, Ward ward) {
        this.restaurantName = restaurantName;
        this.phone = phone;
        this.description = description;
        this.openingHours = openingHours;
        this.closingHours = closingHours;
        this.status = status;
        this.ward = ward;
    }

}
