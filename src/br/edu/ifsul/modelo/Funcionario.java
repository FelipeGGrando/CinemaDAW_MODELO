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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_funcionario", sequenceName = "seq_funcionario_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_funcionario",strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O nome deve ser informado")
    @NotBlank(message = "O nome não pode ficar em branco")
    @Length(max = 50, message = "O nome não pode ter mais de {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @CPF(message = "O CPF deve ser válido")
    @NotNull(message = "O CPF deve ser informado")
    @NotBlank(message = "O CPF não pode ficar em branco")
    @Length(max = 14, message = "O CPF não pode ter mais de {max} caracteres")
    @Column(name = "cpf", length = 14, nullable = false)        
    private String cpf;
    @NotNull(message = "A data de nascimento deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento", nullable = false)
    private Calendar nascimento;
    @NotNull(message = "O telefone deve ser informado")
    @NotBlank(message = "O telefone não pode ficar em branco")
    @Length(max = 20, message = "O telefone não pode ter mais de {max} caracteres")
    @Column(name = "telefone", length = 20, nullable = false)
    private String telefone;
    
    public Funcionario() {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
