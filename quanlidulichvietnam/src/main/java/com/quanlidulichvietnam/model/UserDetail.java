/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quanlidulichvietnam.model;

import jakarta.persistence.*;
import java.util.Date;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "UserDetail")
public class UserDetail {

    @Id
    private int userId;

    @Column(nullable = false, columnDefinition = "NVARCHAR(255)")
    private String fullName;

    @Column(nullable = false, columnDefinition = "NVARCHAR(255)")
    private String email;

    @Column(nullable = false, columnDefinition = "NVARCHAR(50)")
    private String phone;

    @Column(nullable = false, columnDefinition = "NVARCHAR(255)")
    private String address;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(nullable = false, columnDefinition = "BIT")
    private byte gender;

    @Column(nullable = true, length = 255, columnDefinition = "NVARCHAR(255)")
    private String culinaryPreferences;

    @OneToOne
    @MapsId
    @JoinColumn(name = "userId")
    private User user;

    public UserDetail(int userId, String fullName, String email, String phone, String address, Date dob, byte gender) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
    }
}
