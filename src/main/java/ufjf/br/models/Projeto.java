package ufjf.br.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
public class Projeto {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToMany
    private List<Colaborador> coordenadorProjeto;

    @Column(nullable = false)
    @NotBlank(message = "Preencha o nome do Projeto")
    private String nome;

    @Column(name = "num_bolsas")
    @NotBlank(message = "Preencha o número de Bolsistas")
    private Integer numBolsas;

    @Column(name = "num_voluntarios")
    @NotBlank(message = "Preencha o número de Voluntários")
    private Integer numVoluntarios;

    @Column(nullable = false, name = "dt_inicio")
    @NotNull(message = "Informe data de início do projeto")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dtInicio;

    @Column(nullable = false, name = "dt_fim")
    @NotNull(message = "Informe data de encerramento do projeto")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dtFim;

    @Column(name = "tipo_projeto")
    @NotBlank(message = "Preencha a classificação do Projeto")
    private String tipoProjeto;

    @Column(name = "orgao_projeto")
    @NotBlank(message = "Preencha o Órgao de Fomento do Projeto")
    private String orgaoProjeto;

    @Column(name = "resumo")
    @NotBlank(message = "Preencha o resumo do Projeto")
    private String resumo;

    @Override
    public String toString() {
        return "Projeto{" +
                "id=" + id +
                ", coordenadorProjeto='" + coordenadorProjeto + '\'' +
                ", nome='" + nome + '\'' +
                ", numBolsas=" + numBolsas +
                ", numVoluntarios=" + numVoluntarios +
                ", dtInicio=" + dtInicio +
                ", dtFim=" + dtFim +
                ", tipoProjeto='" + tipoProjeto + '\'' +
                ", orgaoProjeto='" + orgaoProjeto + '\'' +
                ", resumo='" + resumo + '\'' +
                '}';
    }

    public Projeto() {}

    public Projeto(List<Colaborador> coordenadorProjeto, String rg, String email, String nome, Integer numBolsas, Date dtInicio, Date dtFim, String tipoProjeto, String orgaoProjeto, String resumo) {
        this.coordenadorProjeto = coordenadorProjeto;
        this.nome = nome;
        this.numBolsas = numBolsas;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
        this.tipoProjeto = tipoProjeto;
        this.orgaoProjeto = orgaoProjeto;
        this.resumo = resumo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Colaborador> getCoordenadorProjeto() {
        return coordenadorProjeto;
    }

    public void setCoordenadorProjeto(List<Colaborador> coordenadorProjeto) {
        this.coordenadorProjeto = coordenadorProjeto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumBolsas() {
        return numBolsas;
    }

    public void setNumBolsas(Integer numBolsas) {
        this.numBolsas = numBolsas;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Date getDtFim() {
        return dtFim;
    }

    public void setDtFim(Date dtFim) {
        this.dtFim = dtFim;
    }

    public String getTipoProjeto() {
        return tipoProjeto;
    }

    public void setTipoProjeto(String tipoProjeto) {
        this.tipoProjeto = tipoProjeto;
    }

    public String getOrgaoProjeto() {
        return orgaoProjeto;
    }

    public void setOrgaoProjeto(String orgaoProjeto) {
        this.orgaoProjeto = orgaoProjeto;
    }

    public String getResumo() { return resumo; }

    public void setResumo(String resumo) { this.resumo = resumo; }

    public Integer getNumVoluntarios() {
        return numVoluntarios;
    }

    public void setNumVoluntarios(Integer numVoluntarios) {
        this.numVoluntarios = numVoluntarios;
    }
}
