package com.restapi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.api.entities.User;
import com.restapi.api.services.services;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
//manejamos las llamadas de la ruta users
@RequestMapping("/users")
public class controller {

      @Autowired
      private services servicesUsers; 

      //get
      @GetMapping("/getAllUsers")
      public List<User> getAllUsers() {
          return servicesUsers.getUsers();
      }

      //get
      @GetMapping("/getUser/{ID}")
      public User getByID(@PathVariable Long ID) {
          return servicesUsers.getUserbyID(ID);
      }

      //post
     @PostMapping("/createUser")
     public String createUser(@RequestBody User user) {
         //TODO: process POST request
         return servicesUsers.createUser(user);
     }
     

     //update
     @PutMapping("/updateUser/{ID}")
     public String putMethodName(@PathVariable Long ID, @RequestBody User user) {
         return servicesUsers.updateUser(ID, user);
     }


     //delete
     @DeleteMapping("/deleteUser/{ID}")
     public String deleteUser(@PathVariable Long ID){
       return servicesUsers.deleteUserByID(ID);
     }

}
