package ufjf.br.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufjf.br.models.ListaEspera;
import ufjf.br.repository.ListaEsperaRepository;

import java.util.List;

@Service
public class ListaEsperaService {

    @Autowired
    private ListaEsperaRepository listaEsperaRepository;

    public List<ListaEspera> findAll(){return listaEsperaRepository.findAll();}

    public List<ListaEspera> findAllByOrderById(){
        return listaEsperaRepository.findAllByOrderById();
    }
    public ListaEspera findOne(Integer id){
        return listaEsperaRepository.findOne(id);
    }

    public ListaEspera save(ListaEspera listaEspera){
        return listaEsperaRepository.saveAndFlush(listaEspera);
    }

    public void delete(Integer id){
        listaEsperaRepository.delete(id);
    }


}
