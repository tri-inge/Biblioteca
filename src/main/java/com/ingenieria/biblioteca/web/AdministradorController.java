/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingenieria.biblioteca.web;


import com.ingenieria.biblioteca.controlador.AdministradorJpaController;
import com.ingenieria.biblioteca.modelo.Administrador;
import com.ingenieria.biblioteca.modelo.PersistenceUtil;
import java.util.Comparator;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author alexis
 */
@ManagedBean
@RequestScoped
public class AdministradorController {
    AdministradorJpaController jpa;
    Administrador administrador ;
    List<Administrador> lista;
    
    /**
     * Creates a new instance of AdministradorController
     */
    public AdministradorController() {
        jpa = new AdministradorJpaController(PersistenceUtil.getEntityManagerFactory());
        administrador = new Administrador();
        lista = jpa.findAdministradorEntities();
    }
        public Administrador getAdministrador(){
        return administrador;
    }
    
    public void setAdministrador(Administrador a){
        administrador = a;
    }
    
   public String addAdministrador(){
       jpa.create(administrador);
       return "lista";
   }
   
   public List<Administrador> getRegistrados(){
       return jpa.findAdministradorEntities();
   }

    public List<Administrador> getLista() {
        return lista;
    }

    public void setLista(List<Administrador> lista) {
        this.lista = lista;
    }
   
   public void guardar() {
        jpa.guardar(administrador);
        lista = jpa.findAdministradorEntities();
    }
   
   
    
}
