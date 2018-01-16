package ufjf.br.models;

import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.*;

@Entity
public class Setor {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    @NotBlank(message = "Preencha o Setor")
    private String setor;

    @Override
    public String toString() {
        return "TypeofService{" +
                "id=" + id +
                ", setor='" + setor + '\'' +
                '}';
    }

    public Setor() {
    }

    public Setor(String setor) {
        this.setor = setor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}
