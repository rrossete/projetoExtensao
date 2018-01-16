package ufjf.br.service;

import ufjf.br.models.DemandaJuridica;
import ufjf.br.repository.DemandaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandaJuridicaService {

    @Autowired
    private DemandaJuridicaRepository demandaJuridicaRepository;

    public List<DemandaJuridica> findAll(){
        return demandaJuridicaRepository.findAll();
    }

    public DemandaJuridica findOne(Integer id)
    {
        return demandaJuridicaRepository.findOne(id);
    }

    public DemandaJuridica save (DemandaJuridica demandaJuridica)
    {
        return demandaJuridicaRepository.saveAndFlush(demandaJuridica);
    }

    public void delete (Integer id)
    {
        demandaJuridicaRepository.delete(id);
    }
}
