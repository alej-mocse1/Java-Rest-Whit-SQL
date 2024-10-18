package com.restapi.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.api.dao.tarjetaDao.tarjetaDAOimp;
import com.restapi.api.dao.userDao.userDAOimp;
import com.restapi.api.entities.Tarjeta;
import com.restapi.api.entities.User;

@Service
public class servicesTarjeta {

    @Autowired
    tarjetaDAOimp tarjetaDAO;
    
    @Autowired
    userDAOimp userDAOimp;

    public String createTarget(Tarjeta tarjeta, Long userID){
    ///falta la logica de negocio para validar que el usuario exista;
    
        try {
           User isUser = userDAOimp.userFindByID(userID);
           return tarjetaDAO.createTarjeta(tarjeta,isUser);  
        } catch (Exception e) {
            return "El usuario no se pudo crear correctamente";
        }

    }
}
