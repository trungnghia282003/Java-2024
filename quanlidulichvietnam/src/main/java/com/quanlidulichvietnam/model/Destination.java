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
@Table(name = "Destination")
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, columnDefinition = "NVARCHAR(255)")
    private String destinationName;

    @Column(columnDefinition = "NVARCHAR(255)")
    private String image;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "ward_id", nullable = false)
    private Ward ward;

    @OneToMany(mappedBy = "destination")
    Set<DestinationServicePrice> destinationServicePrices;

    public Destination(String destinationName, String image, String description, Ward ward) {
        this.destinationName = destinationName;
        this.image = image;
        this.description = description;
        this.ward = ward;
    }

}
