package com.restapi.api.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Favorites {

    //properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Description;
    private Long idUser;



    @ManyToOne()
    @JoinColumn(name = "User_Associate")
    @JsonBackReference 
    private User userFavs;

    
    ///getters and setters
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }
    public Long getIdUser() {
        return idUser;
    }
    public void setIdUser(Long idProperty) {
        this.idUser = idProperty;
    }
    
    public User getUserFavs() {
        return userFavs;
    }
    
    public void setUserFavs(User userFavs) {
        this.userFavs = userFavs;
    }

}
