package ufjf.br.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufjf.br.models.ListaEspera;
import ufjf.br.models.controleHorarios;
import ufjf.br.repository.ControleHorariosRepository;

import java.util.List;

@Service
public class ControleHorariosService {

    @Autowired
    private ControleHorariosRepository service;

    public List<controleHorarios> findAllByOrderByPreAtendimento()
    {
        return service.findAllByOrderByPreAtendimento();
    }

    public List<controleHorarios> findAll() {
        return service.findAll();
    }

    public controleHorarios findOne(Integer id) {
        return service.findOne(id);
    }

    public controleHorarios save(controleHorarios entity) {
        return service.saveAndFlush(entity);
    }

    public void delete(Integer id) { service.delete(id); }


    }









