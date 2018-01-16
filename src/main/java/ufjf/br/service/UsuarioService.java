package ufjf.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ufjf.br.models.Usuario;
import ufjf.br.repository.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {

//    @Autowired
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findOne(Integer id) {
        return usuarioRepository.findOne(id);
    }

    public Usuario save(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.saveAndFlush(usuario);
    }

    public List<Usuario> findbyName(String nome) {
        return usuarioRepository.buscaPorNome(nome);
    }

    public void delete(Integer id) {
        usuarioRepository.delete(id);
    }
}
