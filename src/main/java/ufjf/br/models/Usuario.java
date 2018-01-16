package ufjf.br.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import ufjf.br.validation.PasswordMatches;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.executable.ValidateOnExecution;
import java.util.Date;

@Entity
@NamedQuery(name = "Usuario.buscaPorNome",query = "select u from Usuario u where LOWER(u.nome) like concat(lower(?1),'%')")
@Table(name = "usuario")
//@PasswordMatches
public class Usuario {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    @NotBlank(message = "Preencha o Nome")
    private String nome;

    @Column(nullable = false)
    @NotBlank(message = "Informe a matrícula")
    private String matricula_ufjf;

    private String telefone;

    private String celular;

    @Column(name = "senha")
    @NotBlank(message = "Deve ser informada uma senha")
    @Length(min = 6,message = "A senha deve conter no mínimo seis digítos")
    private String password;

    @NotBlank(message = "Confirme a senha")
    @Length(min = 6,message = "A senha deve conter no mínimo seis digítos")
    private String matchingPassword;

    @Email
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Preencha o e-mail")
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = false)
    private Date dt_criacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dt_exclusao;

    @ManyToOne
    @Valid
    private Endereco endereco;

    @OneToOne
    private Colaborador colaborador;

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", matricula_ufjf='" + matricula_ufjf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                ", dt_criacao=" + dt_criacao +
                ", dt_exclusao=" + dt_exclusao +
                ", endereco=" + endereco +
                ", colaborador=" + colaborador +
                '}';
    }

    public Usuario() {
    }

    public Usuario(String nome, String matricula_ufjf, String telefone, String celular, String email, Endereco endereco, Colaborador colaborador) {
        this.nome = nome;
        this.matricula_ufjf = matricula_ufjf;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.endereco = endereco;
        this.colaborador = colaborador;
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

    public String getMatricula_ufjf() {
        return matricula_ufjf;
    }

    public void setMatricula_ufjf(String matricula_ufjf) {
        this.matricula_ufjf = matricula_ufjf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDt_criacao() {
        return dt_criacao;
    }

    public void setDt_criacao(Date dt_criacao) {
        this.dt_criacao = dt_criacao;
    }

    public Date getDt_exclusao() {
        return dt_exclusao;
    }

    public void setDt_exclusao(Date dt_exclusao) {
        this.dt_exclusao = dt_exclusao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }
}
