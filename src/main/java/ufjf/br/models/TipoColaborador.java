package ufjf.br.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "tipocolaborador")
public class TipoColaborador {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    @NotBlank(message = "Informe o tipo de colaborador")
    private String tipo;


    @Override
    public String toString() {
        return "tiposColaborador{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    public TipoColaborador() {
    }

    public TipoColaborador(String tipo) {
        this.tipo = tipo;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
