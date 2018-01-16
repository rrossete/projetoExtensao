package ufjf.br.models;

import javax.persistence.*;

@Entity
public class OrgaoFomento {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String nome;

    @Column
    private String nome_completo;

    public OrgaoFomento() {
    }

    public OrgaoFomento(String nome, String nome_completo) {
        this.nome = nome;
        this.nome_completo = nome_completo;
    }

    @Override
    public String toString() {
        return "OrgaoFomento{" +
                "nome='" + nome + '\'' +
                ", nome_completo=" + nome_completo +
                '}';
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

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }
}
