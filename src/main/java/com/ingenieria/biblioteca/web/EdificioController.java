/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingenieria.biblioteca.web;

import com.ingenieria.biblioteca.controlador.EdificioJpaController;
import com.ingenieria.biblioteca.modelo.Edificio;
import com.ingenieria.biblioteca.modelo.PersistenceUtil;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author alexis
 */
@ManagedBean
@RequestScoped
public class EdificioController {
    
    EdificioJpaController jpa;
    Edificio edificio;
    List<Edificio> lista;
    
    /**
     * Creates a new instance of EdificioController
     */
    public EdificioController() {
        jpa = new EdificioJpaController(PersistenceUtil.getEntityManagerFactory());
        edificio = new Edificio();
        lista = jpa.findEdificioEntities();
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public List<Edificio> getLista() {
        return lista;
    }

    public void setLista(List<Edificio> lista) {
        this.lista = lista;
    }
    

    public String addProfesor() {
        jpa.create(edificio);
        return "lista";
    }

    public void guardar() {
        jpa.guardar(edificio);
        lista = jpa.findEdificioEntities();
    }
    
    
}
