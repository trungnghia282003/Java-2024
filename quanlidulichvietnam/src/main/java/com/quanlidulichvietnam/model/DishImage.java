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
@Table(name = "DishImage")
public class DishImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "NVARCHAR(255)")
    private String fileName;

    @Column(columnDefinition = "NVARCHAR(255)")
    private String filePath;

    @ManyToOne
    @JoinColumn(name = "dish_id", nullable = false)
    private Dish dish;

    @ManyToOne
    @JoinColumn(name = "image_type_id", nullable = false)
    private ImageType imageType;

    public DishImage(String fileName, String filePath, Dish dish, ImageType imageType) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.dish = dish;
        this.imageType = imageType;
    }

}
