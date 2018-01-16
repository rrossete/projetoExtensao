package ufjf.br.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
public class DemandaJuridica {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    @NotBlank(message = "Preencha a Demanda Juridica")
    private String demanda_juridica;

    @Override
    public String toString()
    {
        return "DemandaJuridica{"+"id="+ id +
                ", demanda_juridica ='" + demanda_juridica+ '}';

    }

    public DemandaJuridica()
    {


    }

    public DemandaJuridica(String demanda_juridica) {
        this.demanda_juridica = demanda_juridica;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDemanda_juridica() {
        return demanda_juridica;
    }

    public void setDemanda_juridica(String demanda_juridica) {
        this.demanda_juridica = demanda_juridica;
    }
}
