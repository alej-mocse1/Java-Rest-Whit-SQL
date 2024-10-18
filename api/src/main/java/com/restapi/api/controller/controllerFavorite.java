package com.restapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.api.entities.Favorites;
import com.restapi.api.services.serviceFavorites;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/favorites")
public class controllerFavorite {
  
    @Autowired
    private serviceFavorites serviceFavorites;


    @PostMapping("/create")
    public String createFav(@RequestBody Favorites favorite) {
        //TODO: process POST request
       return serviceFavorites.AsocciateFavorite(favorite, favorite.getIdUser());
    }


    @DeleteMapping("/delete/{ID}")
    public String deleteFav(@PathVariable Long ID){
        return serviceFavorites.deleteFavoriteByID(ID);
    }
    
}
