/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controller;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author MY
 */
@Entity
@Table(name="PLAYERS")
public class Players implements Serializable {

    @Id
    @Column(name="RANK")
    private String rank;
    
    @Column(name="PLAYER")
    private String playerName;
    
    @Column(name="TEAM")
    private String team;

    public Players() {
    }
    
    
    public Players(String rank, String playerName, String team) {
        this.rank = rank;
        this.playerName = playerName;
        this.team = team;
    }

    public String getRank() {
        return rank;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getTeam() {
        return team;
    }


 
    
}
