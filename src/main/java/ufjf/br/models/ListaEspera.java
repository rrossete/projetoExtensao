package ufjf.br.models;

import javax.persistence.*;

@Entity
@Table(name = "lista_espera")
public class ListaEspera {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private DemandaJuridica demandaJuridica;

    private String observacoes;

    @Override
    public String toString() {
        return "ListaEspera{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", demandaJuridica=" + demandaJuridica +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }

    public ListaEspera(){}

    public ListaEspera(Cliente cliente, DemandaJuridica demandaJuridica, String observacoes) {
        this.cliente = cliente;
        this.demandaJuridica = demandaJuridica;
        this.observacoes = observacoes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public DemandaJuridica getDemandaJuridica() {
        return demandaJuridica;
    }

    public void setDemandaJuridica(DemandaJuridica demandaJuridica) {
        this.demandaJuridica = demandaJuridica;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }


}
