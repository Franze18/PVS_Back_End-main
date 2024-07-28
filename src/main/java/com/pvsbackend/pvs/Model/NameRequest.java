package com.pvsbackend.pvs.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class NameRequest {
    @Id
    @GeneratedValue
    private Long id;

    private Long productId;
    private String surname;
    private String teamName;
    private String hasShort;
    private int playerNumber;

    public NameRequest(){}

    public NameRequest(Long productId, String surname, String teamName, String hasShort, int playerNumber) {
        this.productId = productId;
        this.surname = surname;
        this.teamName = teamName;
        this.hasShort = hasShort;
        this.playerNumber = playerNumber;
    }

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getHasShort() {
        return hasShort;
    }

    public void setHasShort(String hasShort) {
        this.hasShort = hasShort;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    
    
}
