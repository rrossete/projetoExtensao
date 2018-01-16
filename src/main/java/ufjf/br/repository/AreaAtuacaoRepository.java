package ufjf.br.repository;


import org.springframework.stereotype.Repository;
import ufjf.br.models.AreaAtuacao;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AreaAtuacaoRepository extends JpaRepository<AreaAtuacao, Integer> {
}
