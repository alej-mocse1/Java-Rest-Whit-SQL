package com.restapi.api.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;


@Entity
public class Tarjeta {

        //properties
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private Long id;
        private Long idUSER;
        private String Numero;
        private Long Cod;
        private String FechaLimite;

        @OneToOne()
        @JoinColumn(name = "User_Asociado")
        //@JsonManagedReference // Evita el ciclo en la serialización de JSON
        User user;
        
        public Long getIdUSER() {
            return idUSER;
        }

        public void setIdUSER(Long idUSER) {
            this.idUSER = idUSER;
        }

        public String getNumero() {
            return Numero;
        }

        public void setNumero(String numero) {
            Numero = numero;
        }

        public Long getCod() {
            return Cod;
        } 

        public void setCod(Long cod) {
           this.Cod = cod;
        }

        public String getFechaLimite() {
            return FechaLimite;
        }

        public void setFechaLimite(String fechaLimite) {
            FechaLimite = fechaLimite;
        }

        public void setUserAsociado(User userAsoc) {
            this.user = userAsoc;
        }

}
