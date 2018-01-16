package ufjf.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufjf.br.models.Endereco;
import ufjf.br.repository.EnderecoRepository;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    public Endereco findOne(Integer id) {
        return enderecoRepository.findOne(id);
    }

    public Endereco save(Endereco endereco) {
        return enderecoRepository.saveAndFlush(endereco);
    }

    public void delete(Integer id) {
        enderecoRepository.delete(id);
    }
}
