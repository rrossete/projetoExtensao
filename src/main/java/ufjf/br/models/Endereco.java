package ufjf.br.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Endereco {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    @NotBlank(message = "CEP não pode ficar em branco")
    private String cep;

    @Column(nullable = false)
    @NotBlank(message = "Logradouro não pode ficar em branco")
    private String logradouro;

    @Column(nullable = false)
    @NotBlank(message = "Número não pode ficar em branco")
    private String numero;

    private String complemento;

    @Column(nullable = false)
    @NotBlank(message = "Bairro não pode ficar em branco")
    private String bairro;

    @ManyToOne
    @NotNull(message = "Selecione uma Cidade")
    private Cidade cidade;

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }

    public Endereco() {
    }

    public Endereco(String cep, String logradouro, String numero, String complemento, String bairro, Cidade cidade) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
