/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author Felipe
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "ingresso_inteiro")
public class IngressoInteiro extends Ingresso implements Serializable{
    public IngressoInteiro() {
        
    }
}
