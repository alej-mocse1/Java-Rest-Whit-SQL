package com.restapi.api.dao.tarjetaDao;

import org.springframework.stereotype.Repository;
import com.restapi.api.dao.tarjetaDao.interfaces.interfaceTarjetaDAO;
import com.restapi.api.entities.Tarjeta;
import com.restapi.api.entities.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class tarjetaDAOimp implements interfaceTarjetaDAO{
 
   @PersistenceContext
   private EntityManager entityManager; 


   @Override
   @Transactional
   public String createTarjeta(Tarjeta tarjeta, User user){

    tarjeta.setUserAsociado(user);
    user.setTarjeta(tarjeta);

    entityManager.persist(user);
    
    return "Tarjeta creada y asociada";
   }

}
