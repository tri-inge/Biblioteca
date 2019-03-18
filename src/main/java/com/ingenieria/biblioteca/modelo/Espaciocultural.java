/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingenieria.biblioteca.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alexis
 */
@Entity
@Table(name = "espaciocultural")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Espaciocultural.findAll", query = "SELECT e FROM Espaciocultural e")
    , @NamedQuery(name = "Espaciocultural.findByIdevento", query = "SELECT e FROM Espaciocultural e WHERE e.idevento = :idevento")
    , @NamedQuery(name = "Espaciocultural.findByFehca", query = "SELECT e FROM Espaciocultural e WHERE e.fehca = :fehca")
    , @NamedQuery(name = "Espaciocultural.findByNombreevento", query = "SELECT e FROM Espaciocultural e WHERE e.nombreevento = :nombreevento")
    , @NamedQuery(name = "Espaciocultural.findByHora", query = "SELECT e FROM Espaciocultural e WHERE e.hora = :hora")})
public class Espaciocultural implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idevento")
    private Integer idevento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fehca")
    @Temporal(TemporalType.DATE)
    private Date fehca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombreevento")
    private String nombreevento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @JoinColumn(name = "idsala", referencedColumnName = "idsala")
    @ManyToOne(optional = false)
    private Salacultural idsala;

    public Espaciocultural() {
    }

    public Espaciocultural(Integer idevento) {
        this.idevento = idevento;
    }

    public Espaciocultural(Integer idevento, Date fehca, String nombreevento, Date hora) {
        this.idevento = idevento;
        this.fehca = fehca;
        this.nombreevento = nombreevento;
        this.hora = hora;
    }

    public Integer getIdevento() {
        return idevento;
    }

    public void setIdevento(Integer idevento) {
        this.idevento = idevento;
    }

    public Date getFehca() {
        return fehca;
    }

    public void setFehca(Date fehca) {
        this.fehca = fehca;
    }

    public String getNombreevento() {
        return nombreevento;
    }

    public void setNombreevento(String nombreevento) {
        this.nombreevento = nombreevento;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Salacultural getIdsala() {
        return idsala;
    }

    public void setIdsala(Salacultural idsala) {
        this.idsala = idsala;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idevento != null ? idevento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Espaciocultural)) {
            return false;
        }
        Espaciocultural other = (Espaciocultural) object;
        if ((this.idevento == null && other.idevento != null) || (this.idevento != null && !this.idevento.equals(other.idevento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ingenieria.biblioteca.modelo.Espaciocultural[ idevento=" + idevento + " ]";
    }
    
}
