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
@Table(name = "sala")
public class Sala implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_sala", sequenceName = "seq_sala_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_sala", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O nome deve ser informado")
    @NotBlank(message = "O nome não pode ficar em branco")
    @Length(max = 20, message = "O nome não pode ter mais de {max} caracteres")
    @Column(name = "nome", length = 20, nullable = false)
    private String nome;
    @NotNull(message = "A capacidade deve ser informada")
    @Column(name = "capacidade", nullable = false)
    private Integer capacidade;
    @NotNull(message = "A descrição deve ser informada")
    @NotBlank(message = "A descrição não pode ficar em branco")
    @Length(max = 100, message = "A descrição não pode ter mais de {max} caracteres")
    @Column(name = "descricao", length = 100, nullable = false)
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "funcionario", referencedColumnName = "id", nullable = false)
    private Funcionario funcionario;
    
    public Sala() {
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return capacidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.capacidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.id);
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
        final Sala other = (Sala) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
}
