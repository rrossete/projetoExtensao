package ufjf.br.models;


import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.*;

@Entity
@Table(name="parametrosdosistema")
public class ParametrosDoSistema {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, length = 200)
    @NotBlank(message = "Preencha o Nome")
    private String nome;

    @Column(nullable = false, length = 5)
    private int numero_minimo_horas;

    @Column(nullable = false)
    private int numero_maximo_alunos;

    @Override
    public String toString() {
        return "ParametrosDoSistema{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", numero_minimo_horas='" + numero_minimo_horas + '\'' +
                ", numero_maximo_alunos='" + numero_maximo_alunos + '\'' +
                '}';
    }

    public ParametrosDoSistema() {
    }

    public ParametrosDoSistema(String nome, int numero_minimo_horas, int numero_maximo_alunos) {
        this.nome = nome;
        this.numero_minimo_horas = numero_minimo_horas;
        this.numero_maximo_alunos = numero_maximo_alunos;
    }

    public int getNumero_maximo_alunos() {
        return numero_maximo_alunos;
    }

    public void setNumero_maximo_alunos(int numero_maximo_alunos) {
        this.numero_maximo_alunos = numero_maximo_alunos;
    }

    public int getNumero_minimo_horas() {
        return numero_minimo_horas;
    }

    public void setNumero_minimo_horas(int numero_minimo_horas) {
        this.numero_minimo_horas = numero_minimo_horas;
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
}
