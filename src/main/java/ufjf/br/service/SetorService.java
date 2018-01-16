package ufjf.br.service;


import ufjf.br.models.Setor;
import ufjf.br.repository.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetorService {

    @Autowired
    private SetorRepository setorRepository;

    public List<Setor> findAll() {
        return setorRepository.findAll();
    }

    public Setor findOne(Integer id) {
        return setorRepository.findOne(id);
    }

    public Setor save(Setor typeofService) {
        return setorRepository.saveAndFlush(typeofService);
    }

    public void delete(Integer id) {
        setorRepository.delete(id);
    }
}
