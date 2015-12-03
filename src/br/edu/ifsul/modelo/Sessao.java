/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "sessao")
public class Sessao implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_sessao", sequenceName = "seq_sessao_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_sessao", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "A data da sessão deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_sessao", nullable = false)
    private Calendar data_sessao;
    @NotNull(message = "O horário deve ser informado")
    @NotBlank(message = "O horário não pode ficar em branco")
    @Length(max = 5, message = "O horário não pode ter mais de {max} caracteres")
    @Column(name = "horario", length = 5, nullable = false)
    private String horario;
    @ManyToOne
    @JoinColumn(name = "filme", referencedColumnName = "id", nullable = false)
    private Filme filme;
    @ManyToOne
    @JoinColumn(name = "sala", referencedColumnName = "id", nullable = false)
    private Sala sala;
    
    public Sessao() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData_sessao() {
        return data_sessao;
    }

    public void setData_sessao(Calendar data_sessao) {
        this.data_sessao = data_sessao;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Sessao other = (Sessao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
