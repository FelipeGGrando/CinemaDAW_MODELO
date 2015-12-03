/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "filme")
public class Filme implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_filme", sequenceName = "seq_filme_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_filme", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O título deve ser informado")
    @NotBlank(message = "O título não pode ficar em branco")
    @Length(max = 100, message = "O título não pode ter mais de {max} caracteres")
    @Column(name = "titulo", length = 100, nullable = false)
    private String titulo;
    @NotNull(message = "A sinopse deve ser informada")
    @NotBlank(message = "A sinopse não pode ficar em branco")
    @Length(max = 1000, message = "A sinopse não pode ter mais de {max} caracteres")
    @Column(name = "sinopse", length = 1000, nullable = false)
    private String sinopse;
    @NotNull(message = "A duração deve ser informada")
    @Column(name = "duracao", nullable = false)
    private Integer duracao;
    @NotNull(message = "O gênero deve ser informada")
    @NotBlank(message = "O gênero não pode ficar em branco")
    @Length(max = 20, message = "O gênero não pode ter mais de {max} caracteres")
    @Column(name = "genero", length = 20, nullable = false)
    private String genero;
    @NotNull(message = "Legendado não pode ser nulo")
    @Column(name = "legendado", nullable = false)
    private Boolean legendado;
    @NotNull(message = "Dublado não pode ser nulo")
    @Column(name = "dublado", nullable = false)
    private Boolean dublado;
    @NotNull(message = "A faixa etária deve ser informada")
    @Column(name = "faixa_etaria", nullable = false)
    private Integer faixa_etaria;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "filmes_atores",
            joinColumns = 
            @JoinColumn(name = "filme", referencedColumnName = "id"),
            inverseJoinColumns = 
            @JoinColumn(name = "ator", referencedColumnName = "id"))
    private List<Ator> atores = new ArrayList<>();
    @NotNull(message = "O diretor deve ser informado")
    @ManyToOne
    @JoinColumn(name = "diretor", referencedColumnName = "id", nullable = false)    
    private Diretor diretor;
    
    public Filme() {
        
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Boolean getLegendado() {
        return legendado;
    }

    public void setLegendado(Boolean legendado) {
        this.legendado = legendado;
    }

    public Boolean getDublado() {
        return dublado;
    }

    public void setDublado(Boolean dublado) {
        this.dublado = dublado;
    }

    public Integer getFaixa_etaria() {
        return faixa_etaria;
    }

    public void setFaixa_etaria(Integer faixa_etaria) {
        this.faixa_etaria = faixa_etaria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Filme other = (Filme) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return titulo;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }
    
}
