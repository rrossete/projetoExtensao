package ufjf.br.models;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="cliente")
public class Cliente {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, length = 200)
    @NotBlank(message = "Preencha o Nome")
    private String nome;

    @ManyToOne
    @Valid
    private Endereco endereco;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Preencha o RG")
    private String rg;

    @Column(nullable = false)
    @NotBlank(message = "Preencha o CPF")
    private String cpf;

    @Column(name = "nome_pai", nullable = true)
    private String nomePai;

    @Column(name = "nome_mae", nullable = false)
    @NotBlank(message = "Digite o nome da Mãe")
    private String nomeMae;

    @Column(name = "dt_nascimento")
    @NotBlank(message = "Informe data de nascimento do cliente")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date nascimento;

    private String nacionalidade;
    private String naturalidade;
    private String profissao;

    @Column(name = "estado_civil", nullable = true)
    private String estadoCivil;

    @Column(name = "telefone_residencial", nullable = true)
    private String telResidencial;

    @Column(name = "telefone_celular", nullable = false)
    private String telCelular;

    @Email
    private String email;

    @Column(name = "outro_contato", nullable = true)
    private String outroContato;

    public Cliente() {
    }

    public Cliente(String nome, Endereco endereco, String rg, String cpf, String nomePai, String nomeMae, Date nascimento, String nacionalidade, String naturalidade, String profissao, String estadoCivil, String telResidencial, String telCelular, String email, String outroContato) {
        this.nome = nome;
        this.endereco = endereco;
        this.rg = rg;
        this.cpf = cpf;
        this.nomePai = nomePai;
        this.nomeMae = nomeMae;
        this.nascimento = nascimento;
        this.nacionalidade = nacionalidade;
        this.naturalidade = naturalidade;
        this.profissao = profissao;
        this.estadoCivil = estadoCivil;
        this.telResidencial = telResidencial;
        this.telCelular = telCelular;
        this.email = email;
        this.outroContato = outroContato;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getTelResidencial() {
        return telResidencial;
    }

    public void setTelResidencial(String telResidencial) {
        this.telResidencial = telResidencial;
    }

    public String getTelCelular() {
        return telCelular;
    }

    public void setTelCelular(String telCelular) {
        this.telCelular = telCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOutroContato() {
        return outroContato;
    }

    public void setOutroContato(String outroContato) {
        this.outroContato = outroContato;
    }
}
