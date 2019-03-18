/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingenieria.biblioteca.web;

import com.ingenieria.biblioteca.controlador.EdificioJpaController;
import com.ingenieria.biblioteca.controlador.SalaculturalJpaController;
import com.ingenieria.biblioteca.modelo.Edificio;
import com.ingenieria.biblioteca.modelo.PersistenceUtil;
import com.ingenieria.biblioteca.modelo.Salacultural;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author alexis
 */
@ManagedBean
@RequestScoped
public class SalaculturalController {

    SalaculturalJpaController jpa;
    Salacultural salacultural;
    List<Salacultural> lista;
    EdificioJpaController jpa2;
    List<Edificio> edificios;
    Edificio edificio;

    /**
     * Creates a new instance of SalaController
     */
    public SalaculturalController() {
        jpa = new SalaculturalJpaController(PersistenceUtil.getEntityManagerFactory());
        salacultural = new Salacultural();
        lista = jpa.findSalaculturalEntities();
        jpa2 = new EdificioJpaController(PersistenceUtil.getEntityManagerFactory());
        edificios = jpa2.findEdificioEntities();
        edificio = new Edificio();
    }

    public SalaculturalJpaController getJpa() {
        return jpa;
    }

    public void setJpa(SalaculturalJpaController jpa) {
        this.jpa = jpa;
    }

    public Salacultural getSalacultural() {
        return salacultural;
    }

    public void setSalacultural(Salacultural salacultural) {
        this.salacultural = salacultural;
    }

    public List<Salacultural> getLista() {
        return lista;
    }

    public void setLista(List<Salacultural> lista) {
        this.lista = lista;
    }

    public void guardar() {
        salacultural.setIdedificio(edificio);
        jpa.guardar(salacultural);
        lista = jpa.findSalaculturalEntities();
    }



}
