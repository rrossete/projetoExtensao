package ufjf.br.models;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
public class PreAtendimento {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = true, name = "data_inicial")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-ddThh:mm")
    private Date dataInicial;

    @Column(nullable = true, name = "data_final")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-ddThh:mm")
    private Date dataFinal;

    @NotBlank(message = "Preencha o semestre")
    @Column(nullable=true, name="semestre")
    private String semestre;

    @Transient
    private int duracaoAtendimento;

    @Transient
    private final List<String> diasSemana = new ArrayList<String>(Arrays.asList(new String[]{
            "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo"
    }));

    @Override
    public String toString() {
        return "PreAtendimento{" +
                "id=" + id +
                ", dataInicial=" + dataInicial +
                ", dataFinal=" + dataFinal +
                ", semestre='" + semestre + '\'' +
                ", duracaoAtendimento=" + duracaoAtendimento +
                ", diasSemana=" + diasSemana +
                '}';
    }

    public PreAtendimento() {
    }

    public PreAtendimento( Date dataInicial, Date dataFinal) {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }


    public PreAtendimento(Integer id, Date dataInicial, Date dataFinal) {
        this.id = id;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public String getDataInicialFormatada(){

        SimpleDateFormat formatar = new SimpleDateFormat("dd'-'MM'-'yyyy' 'k':'mm':'ss");
        String data = String.valueOf(getDataInicial());
        data = formatar.format(data);

        return data;

    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public List<String> getDiasSemana() {
        return diasSemana;
    }

    public int getDuracaoAtendimento() {
        return duracaoAtendimento;
    }

    public void setDuracaoAtendimento(int duracaoAtendimento) {
        this.duracaoAtendimento = duracaoAtendimento;
    }
}