package ufjf.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufjf.br.models.OrgaoFomento;
import ufjf.br.repository.OrgaoFomentoRepository;

import java.util.List;

@Service
public class OrgaoFomentoService {
    @Autowired
    private OrgaoFomentoRepository orgaoFomentoRepository;

    public List<OrgaoFomento> findAll() {
        return orgaoFomentoRepository.findAll();
    }

    public OrgaoFomento findOne(Integer id) {
        return orgaoFomentoRepository.findOne(id);
    }

    public OrgaoFomento save(OrgaoFomento activityarea) {
        return orgaoFomentoRepository.saveAndFlush(activityarea);
    }

    public void delete(Integer id) {
        orgaoFomentoRepository.delete(id);
    }
}
