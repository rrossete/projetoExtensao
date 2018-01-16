package ufjf.br.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
public class Cidade {

    @Id
    private Integer id;

    @Column(nullable = false)
    @NotBlank(message = "Informe a cidade do cliente")
    private String nome;

    @OneToOne
    private Estado estado;

    @Override
    public String toString() {
        return nome + " - " + estado.getSigla();
    }

    public Cidade() {
    }

    public Cidade(Integer id, String nome, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}

