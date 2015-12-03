package br.edu.ifsul.modelo;
import java.io.Serializable;
import java.util.Calendar;
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

@Entity
@Table(name = "acesso_usuario")
public class AcessoUsuario implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_acesso", sequenceName = "seq_acesso_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_acesso", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "A data de acesso deve ser informada")    
    @Column(name = "data", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar data;
    @NotBlank(message = "O Ip de acesso deve ser informado")
    @Length(max = 15, message = "O IP de acesso não pode ter mais que {max} caracteres")
    @Column(name = "ip_acesso", length = 15, nullable = false)
    private String ipAcesso;
    @NotNull(message = "O usuario deve ser informado")
    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id", nullable = false)
    private Usuario usuario;

    public AcessoUsuario() {
    }

    public AcessoUsuario(String ipAcesso) {
        this.data = Calendar.getInstance();
        this.ipAcesso = ipAcesso;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getIpAcesso() {
        return ipAcesso;
    }

    public void setIpAcesso(String ipAcesso) {
        this.ipAcesso = ipAcesso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
