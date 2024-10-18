package com.restapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.api.entities.Tarjeta;
import com.restapi.api.entities.User;
import com.restapi.api.services.servicesTarjeta;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/target")
public class controllerTarget {

  @Autowired
  private servicesTarjeta servicesTarget;

  @PostMapping("/createTarget")
  public String postMethodName(@RequestBody Tarjeta tarjeta) {
      return servicesTarget.createTarget(tarjeta, tarjeta.getIdUSER() );
  }

}
