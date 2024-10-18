package com.restapi.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.api.dao.favoritesDao.favoritesDAOimp;
import com.restapi.api.dao.userDao.userDAOimp;
import com.restapi.api.entities.Favorites;
import com.restapi.api.entities.User;


@Service
public class serviceFavorites {

    @Autowired
    private favoritesDAOimp favoritesDAO;

    @Autowired
    userDAOimp userDAOimp;


    public String AsocciateFavorite(Favorites fav , Long userID ){
      try {
         User isUser = userDAOimp.userFindByID(userID);
         return favoritesDAO.createFavorites(fav, isUser);
      } catch (Exception e) {
        // TODO: handle exception
        return "FAIL";
      }
    }

    public String deleteFavoriteByID(Long ID){
        try {
          return favoritesDAO.deleteFavorites(ID);
        } catch (Exception e) {
            // TODO: handle exception
            return "FAIL";
        }
    }


}
