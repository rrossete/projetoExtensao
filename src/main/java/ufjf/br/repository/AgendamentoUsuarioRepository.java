package ufjf.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufjf.br.models.AgendamentoUsuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface AgendamentoUsuarioRepository extends JpaRepository<AgendamentoUsuario, Integer>{

    List<AgendamentoUsuario> findAllByOrderById();
    //ArrayList<String> geraHorario();

}
