package ufjf.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufjf.br.models.Cidade;
import ufjf.br.repository.CidadeRepository;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> findAll() {
        return cidadeRepository.findAll();
    }

    public List<Cidade> findAllByOrderByNome() {
        return cidadeRepository.findAllByOrderByNome();
    }

    public List<Cidade> findAllByEstado_Id(Integer id) {
        return cidadeRepository.findAllByEstado_Id(id);
    }

    public Cidade findOne(Integer id) {
        return cidadeRepository.findOne(id);
    }

    public Cidade save(Cidade cidade) {
        return cidadeRepository.saveAndFlush(cidade);
    }

    public void delete(Integer id) {
        cidadeRepository.delete(id);
    }
}
