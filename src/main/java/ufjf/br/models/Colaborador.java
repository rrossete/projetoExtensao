package ufjf.br.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Colaborador {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    @NotBlank(message = "OAB não pode ficar em branco")
    private String oab;

    @Column
    private Integer carga_horaria;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "tipo_colaborador_id")
    private TipoColaborador tipoColaborador;

    @ManyToOne
    @JoinColumn(name = "setor_id")
    private Setor setor;

    @Override
    public String toString() {
        return "Colaborador{" +
                "id=" + id +
                ", oab='" + oab + '\'' +
                ", carga_horaria=" + carga_horaria +
                ", usuario=" + usuario +
                ", tipoColaborador=" + tipoColaborador +
                ", setor=" + setor +
                '}';
    }

    public Colaborador() {
    }

    public Colaborador(String oab, Integer carga_horaria, Usuario usuario, TipoColaborador tipoColaborador, Setor setor) {
        this.oab = oab;
        this.carga_horaria = carga_horaria;
        this.usuario = usuario;
        this.tipoColaborador = tipoColaborador;
        this.setor = setor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOab() {
        return oab;
    }

    public void setOab(String oab) {
        this.oab = oab;
    }

    public Integer getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(Integer carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoColaborador getTipoColaborador() {
        return tipoColaborador;
    }

    public void setTipoColaborador(TipoColaborador tipoColaborador) {
        this.tipoColaborador = tipoColaborador;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }
}
