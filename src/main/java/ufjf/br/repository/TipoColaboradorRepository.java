package ufjf.br.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ufjf.br.models.TipoColaborador;

public interface TipoColaboradorRepository extends JpaRepository<TipoColaborador, Integer> {
}
