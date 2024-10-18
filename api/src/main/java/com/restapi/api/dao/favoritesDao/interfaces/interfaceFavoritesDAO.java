package com.restapi.api.dao.favoritesDao.interfaces;

import com.restapi.api.entities.Favorites;
import com.restapi.api.entities.User;

public interface interfaceFavoritesDAO {

    public String createFavorites(Favorites fav , User user);
    public String deleteFavorites(Long ID);
    public Favorites favoriteFindByPK(Long ID);
}
