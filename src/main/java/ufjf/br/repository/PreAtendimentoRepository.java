package ufjf.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufjf.br.models.PreAtendimento;

import java.util.List;

public interface PreAtendimentoRepository extends JpaRepository<PreAtendimento, Integer> {

    List<PreAtendimento> findAllByOrderByDataInicial();
}

