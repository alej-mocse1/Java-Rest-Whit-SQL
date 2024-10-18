package com.restapi.api.dao.tarjetaDao.interfaces;

import com.restapi.api.entities.Tarjeta;
import com.restapi.api.entities.User;

public interface interfaceTarjetaDAO {

    String createTarjeta(Tarjeta tarjeta , User user);

}
