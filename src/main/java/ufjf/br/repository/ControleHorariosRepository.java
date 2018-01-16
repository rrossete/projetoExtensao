package ufjf.br.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ufjf.br.models.Cliente;
import ufjf.br.models.controleHorarios;

import java.util.List;

@Repository
public interface ControleHorariosRepository extends JpaRepository<controleHorarios, Integer> {

    List<controleHorarios> findAllByOrderByPreAtendimento();
    List<controleHorarios> findOneById(int id);

    List<controleHorarios> findAllById(int id);
    List<controleHorarios> findAll();
    List<controleHorarios> findAllByCliente(Cliente cliente);
}
