package com.desafio.desafio_boolean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "configuracao")
public class Configuracao {
  
    @Id
    private Integer id;
    private Boolean ativo;

    public Configuracao() {

    }

    public Integer getId() {
        return id;
    }

    public Boolean getAtivo() {
        return ativo;
    }
}
