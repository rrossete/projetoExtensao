package ufjf.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufjf.br.models.TipoColaborador;
import ufjf.br.repository.TipoColaboradorRepository;

import java.util.List;

@Service
public class TipoColaboradorService {
    @Autowired
    private TipoColaboradorRepository tipoColaboradorRepository;

    public List<TipoColaborador> findAll() {
        return tipoColaboradorRepository.findAll();
    }

    public TipoColaborador findOne(Integer id) {
        return tipoColaboradorRepository.findOne(id);
    }

    public TipoColaborador save(TipoColaborador tiposColaborador) {
        return tipoColaboradorRepository.saveAndFlush(tiposColaborador);
    }

    public void delete(Integer id) {
        tipoColaboradorRepository.delete(id);
    }
}
