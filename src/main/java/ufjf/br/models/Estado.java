package ufjf.br.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Estado {

    @Id
    private Integer id;

    @Column(nullable = false)
    @NotBlank(message = "Informe o estado do cliente")
    private String nome;

    @Column(nullable = false)
    private String sigla;

    @Override
    public String toString() {
        return nome + " - " + sigla;
    }

    public Estado() {
    }

    public Estado(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
