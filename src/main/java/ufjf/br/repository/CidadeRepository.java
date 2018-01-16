package ufjf.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ufjf.br.models.Cidade;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
    List<Cidade> findAllByOrderByNome();

    List<Cidade> findAllByEstado_Id(Integer id);
}
