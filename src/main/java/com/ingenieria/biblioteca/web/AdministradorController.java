/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingenieria.biblioteca.web;


import com.ingenieria.biblioteca.controlador.AdministradorJpaController;
import com.ingenieria.biblioteca.modelo.Administrador;
import com.ingenieria.biblioteca.modelo.PersistenceUtil;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author alexis
 */
@Named(value = "administradorController")
@Dependent
public class AdministradorController {
    AdministradorJpaController jpa;
    Administrador administrador ;
    
    /**
     * Creates a new instance of AdministradorController
     */
    public AdministradorController() {
        jpa = new AdministradorJpaController(PersistenceUtil.getEntityManagerFactory());
        administrador = new Administrador(); 
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
   
   public void guardar(){
       jpa.guardar(administrador);
       
   }
   
   public boolean registrarAdministrador() {
        String ePattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@ciencias.unam.mx";
        String numTrab = "^[0-9]+";
        Pattern pattern = Pattern.compile(ePattern);
        Pattern pat = Pattern.compile(numTrab);

        String correo = administrador.getCorreo();
        String numTrabaja = administrador.getNumTrabajador();
        String nombre = administrador.getNombre();
        String cadena = "^[A-Za-z\\s]*";
        Pattern pat1 = Pattern.compile(cadena);

        if (correoExistente(correo)) {
            muestraMensaje("El correo ya esta registrado.");
        } else {
            if (administrador.getCorreo() != null) {
                Matcher matcher = pattern.matcher(correo);
                Matcher mat = pat.matcher(numTrabaja);
                Matcher mat1 = pat1.matcher(nombre);
                if (matcher.matches()) {
                    if (mat.matches()) {
                        System.err.println("Error");
                        if (mat1.matches()) {
                            System.err.println("Numero de trabajador valido Encontrado.");
                            jpa.guardar(profesor);
                            lista = jpa.findAdministradorEntities();
                            String[] params = {"biopractice20191@gmail.com", "Biopractice1234", profesor.getCorreo(), "smtp.gmail.com", "587", "Confirma tu correo", "<a href='localhost:8084/biblioteca'></a>"};
                            new Mailer().envia(params);
                            redirecciona("/index.xhtml");
                            return true;
                        } else {
                            muestraMensaje("Nombre invalido");
                        }

                    } else {
                        muestraMensaje("Ingresa un Numero de trabajador valido");
                    }

                } else {
                    muestraMensaje("Correo invalido");
                }

            }
        }
        return false;

    }
    public void registra() {
        registrarAdministrador();
    }   
    
}
