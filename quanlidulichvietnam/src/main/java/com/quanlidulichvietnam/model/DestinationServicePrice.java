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
@Table(name = "Destination_Service_Price")
public class DestinationServicePrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "destination_id", nullable = false)
    Destination destination;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    Service service;

    @ManyToOne
    @JoinColumn(name = "price_id", nullable = false)
    Price price;

    public DestinationServicePrice(Destination destination, Service service, Price price) {
        this.destination = destination;
        this.service = service;
        this.price = price;
    }

}
