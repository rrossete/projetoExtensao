package ufjf.br.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Entity
public class DisponibilidadeHorario {
    @Id
    @GeneratedValue
    private Integer id_disponibilidade;

    @ManyToOne
    @JoinColumn(name="fk_usuario")
    private Usuario usuario;

    @Column(name="horario_inicio",nullable = false)
    @NotBlank(message = "Preencha a Hora de Início")
    private LocalTime horario_inicio;

    @Column(name="horario_fim",nullable = false)
    @NotNull(message = "Preencha a Hora De Fim")
    private LocalTime horario_fim;

    @Column(name="cargahoraria",nullable = false)
    private LocalTime cargahoraria;

    @Column(nullable = false)
    @NotNull(message = "Preencha o Dia da Semana")
    @Enumerated(EnumType.STRING)
    private Semana dia_semana;

    public DisponibilidadeHorario() {
    }

    public DisponibilidadeHorario(Usuario usuario, LocalTime horaInicio, LocalTime horario_fim, LocalTime cargahoraria, Semana dia_semana) {
        this.usuario = usuario;
        this.horario_inicio = horaInicio;
        this.horario_fim = horario_fim;
        this.cargahoraria = cargahoraria;
        this.dia_semana = dia_semana;
    }

    public Integer getId() {
        return id_disponibilidade;
    }

    public void setId(Integer id) {
        this.id_disponibilidade = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalTime getHorario_inicio() {
        return horario_inicio;
    }

    public void setHorario_inicio(LocalTime horario_inicio) {
        this.horario_inicio = horario_inicio;
    }

    public LocalTime getHorario_fim() {
        return horario_fim;
    }

    public void setHorario_fim(LocalTime horario_fim) {
        this.horario_fim = horario_fim;
    }

    public LocalTime getCargahoraria() {
        return cargahoraria;
    }

    public void setCargahoraria(LocalTime cargahoraria) {
        this.cargahoraria = cargahoraria;
    }

    public Semana getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(Semana dia_semana) {
        this.dia_semana = dia_semana;
    }
}
