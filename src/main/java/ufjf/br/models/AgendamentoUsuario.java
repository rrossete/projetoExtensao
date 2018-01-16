package ufjf.br.models;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
public class AgendamentoUsuario {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String disciplinaEmCurso ;

    @ManyToOne
    private DemandaJuridica demandaJuridica;

    @ManyToOne
    private Usuario usuario1;

    @ManyToOne
    private Usuario usuario2;

    @OneToOne
    private controleHorarios controleHorarios;



    @Override
    public String toString(){

        return "AgendamentoUsuario{"+ "id=" + id +
                ",disciplinaEmCurso="+ disciplinaEmCurso +
                ",demandaJuridica=" + demandaJuridica +
                ", usuario1=" + usuario1 +
                ", usuario2=" + usuario2 +
                ", controleHorarios=" + controleHorarios+ '\'' + "}";
    }



    public AgendamentoUsuario() {
    }

    public AgendamentoUsuario(String disciplinaEmCurso, DemandaJuridica demandaJuridica, Usuario usuario1, Usuario usuario2, ufjf.br.models.controleHorarios controleHorarios) {
        this.disciplinaEmCurso = disciplinaEmCurso;
        this.demandaJuridica = demandaJuridica;
        this.usuario1 = usuario1;
        this.usuario2 = usuario2;
        this.controleHorarios = controleHorarios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisciplinaEmCurso() {
        return disciplinaEmCurso;
    }

    public void setDisciplinaEmCurso(String disciplinaEmCurso) {
        this.disciplinaEmCurso = disciplinaEmCurso;
    }

    public DemandaJuridica getDemandaJuridica() {
        return demandaJuridica;
    }

    public void setDemandaJuridica(DemandaJuridica demandaJuridica) {
        this.demandaJuridica = demandaJuridica;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    public Usuario getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(Usuario usuario2) {
        this.usuario2 = usuario2;
    }

    public ufjf.br.models.controleHorarios getControleHorarios() {
        return controleHorarios;
    }

    public void setControleHorarios(ufjf.br.models.controleHorarios controleHorarios) {
        this.controleHorarios = controleHorarios;
    }
}
