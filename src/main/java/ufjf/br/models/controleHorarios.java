package ufjf.br.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class controleHorarios {

    @Id
    @GeneratedValue
    private int id;

     @ManyToOne
     private Cliente cliente;

     @OneToOne
     private PreAtendimento preAtendimento;

     public controleHorarios(){}

     public controleHorarios(PreAtendimento preAtendimento,Cliente cliente){
         this.preAtendimento = preAtendimento;
         this.cliente = cliente;
     }

    @Override
    public String toString() {
        return "controleHorarios = {" +
                "Cliente" +this.cliente+
                "preAtendimento" +this.preAtendimento
                +'}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public PreAtendimento getPreAtendimento() {
        return preAtendimento;
    }

    public void setPreAtendimento(PreAtendimento preAtendimento) {
        this.preAtendimento = preAtendimento;
    }
}
