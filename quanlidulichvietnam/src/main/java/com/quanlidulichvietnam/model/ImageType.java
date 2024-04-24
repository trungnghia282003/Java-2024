/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quanlidulichvietnam.model;

import jakarta.persistence.*;
import java.util.Set;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ImageType")
public class ImageType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, columnDefinition = "NVARCHAR(255)")
    private String typeName;

    @OneToMany(mappedBy = "imageType")
    private Set<RestaurantImage> restaurantImages;
    
    @OneToMany(mappedBy = "imageType")
    private Set<DishImage> dishImages;

    public ImageType(String typeName) {
        this.typeName = typeName;
    }

}
