package ufjf.br.service;


import ufjf.br.models.ParametrosDoSistema;
import ufjf.br.repository.ParametrosDoSistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParametrosDoSistemaService {

    @Autowired
    private ParametrosDoSistemaRepository parametrosDoSistemaRepository;

    public List<ParametrosDoSistema> findAll() {
        return parametrosDoSistemaRepository.findAll();
    }

    public ParametrosDoSistema findOne(Integer id) {
        return parametrosDoSistemaRepository.findOne(id);
    }

    public ParametrosDoSistema save(ParametrosDoSistema parametrosDoSistema) {
        return parametrosDoSistemaRepository.saveAndFlush(parametrosDoSistema);
    }

    public void delete(Integer id) {
        parametrosDoSistemaRepository.delete(id);
    }
}
