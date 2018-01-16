package ufjf.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufjf.br.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
