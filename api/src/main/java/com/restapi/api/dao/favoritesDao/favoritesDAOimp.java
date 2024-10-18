package com.restapi.api.dao.favoritesDao;


import java.util.List;

import org.springframework.stereotype.Service;

import com.restapi.api.dao.favoritesDao.interfaces.interfaceFavoritesDAO;
import com.restapi.api.entities.Favorites;
import com.restapi.api.entities.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Service
public class favoritesDAOimp implements interfaceFavoritesDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public String createFavorites(Favorites fav , User user) {
       
        fav.setUserFavs(user);

        List<Favorites> Favstotal = user.getFavorites();
        Favstotal.add(fav);
        user.setFavorites(Favstotal);

        entityManager.persist(user);
       
        return "Favorite created and associated";
    }

    @Override
    @Transactional
    public Favorites favoriteFindByPK(Long ID) {
        Favorites favorites = entityManager.find(Favorites.class, ID);

        // Validar que el usuario no sea nulo
        if (favorites != null) {
            return favorites;
        } else {
            // // Manejo de error si el usuario no existe
            return null;
        }
    }

    @Override
    @Transactional
    public String deleteFavorites(Long ID) {

        // buscamos la instacia a eliminar
        Favorites fav = favoriteFindByPK(ID);

        // validamos que exista
        if (fav != null) {
            entityManager.remove(fav);
            return "Favorite Deleted";
        } else {
            return "Error";
        }
    }

}
