package ufjf.br.service;

import ufjf.br.models.Projeto;
import ufjf.br.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository ProjetoRepository;

    public List<Projeto> findAll() {
        return ProjetoRepository.findAll();
    }

    public Projeto findOne(Integer id) {
        return ProjetoRepository.findOne(id);
    }

    public Projeto save(Projeto Projeto) {
        return ProjetoRepository.saveAndFlush(Projeto);
    }

    public void delete(Integer id) {
        ProjetoRepository.delete(id);
    }
}
