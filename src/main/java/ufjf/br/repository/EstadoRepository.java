package ufjf.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufjf.br.models.Estado;

import java.util.List;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {
    public List<Estado> findAllByOrderByNome();
}
