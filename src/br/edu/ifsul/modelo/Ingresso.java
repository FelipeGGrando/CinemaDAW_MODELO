/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "ingresso")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Ingresso implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_ingresso", sequenceName = "seq_ingresso_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_ingresso", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O horário deve ser informado")
    @NotBlank(message = "O horário não pode ficar em branco")
    @Length(max = 5, message = "O horário não pode ter mais de {max} caracteres")
    @Column(name = "horario", length = 5, nullable = false)
    private String horario;
    @NotNull(message = "O valor deve ser informado")
    @Column(name = "valor", nullable = false)
    private Double valor;
    @NotNull(message = "O assento deve ser informado")
    @Column(name = "assento", nullable = false)
    private Integer assento;
    @NotNull(message = "O código de barras deve ser informado")
    @NotBlank(message = "O código de barras não pode ficar em branco")
    @Length(max = 50, message = "O código de barras não pode ter mais de {max} caracteres")
    @Column(name = "codigo_barras", length = 50, nullable = false)
    private String codigo_barras;
    @ManyToOne
    @JoinColumn(name = "sessao", referencedColumnName = "id", nullable = false)
    private Sessao sessao;
    
    public Ingresso() {
        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getAssento() {
        return assento;
    }

    public void setAssento(Integer assento) {
        this.assento = assento;
    }

    public String getCodigo_barras() {
        return codigo_barras;
    }

    public void setCodigo_barras(String codigo_barras) {
        this.codigo_barras = codigo_barras;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ingresso other = (Ingresso) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }
    
}
