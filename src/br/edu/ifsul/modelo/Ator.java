/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "ator")
@Inheritance(strategy = InheritanceType.JOINED)
public class Ator extends Pessoa implements Serializable {
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "filmes_atores",
            joinColumns = 
            @JoinColumn(name = "ator", referencedColumnName = "id"),
            inverseJoinColumns = 
            @JoinColumn(name = "filme", referencedColumnName = "id"))    
    private List<Filme> filmes = new ArrayList<>();
    
    public Ator() {
        
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

}
