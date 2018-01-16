package ufjf.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufjf.br.models.Usuario;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> buscaPorNome(String nome);
}
