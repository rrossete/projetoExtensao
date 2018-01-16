package ufjf.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufjf.br.models.Estado;
import ufjf.br.repository.EstadoRepository;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> findAll() {
        return estadoRepository.findAll();
    }

    public List<Estado> findAllByOrderByNome() {
        return estadoRepository.findAllByOrderByNome();
    }

    public Estado findOne(Integer id) {
        return estadoRepository.findOne(id);
    }

    public Estado save(Estado estado) {
        return estadoRepository.saveAndFlush(estado);
    }

    public void delete(Integer id) {
        estadoRepository.delete(id);
    }
}
