package ufjf.br.service;

import ufjf.br.models.AreaAtuacao;
import ufjf.br.repository.AreaAtuacaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class AreaAtuacaoService {
    @Autowired
    private AreaAtuacaoRepository areaAtuacaoRepository;

    public List<AreaAtuacao> findAll() {
        return areaAtuacaoRepository.findAll();
    }

    public AreaAtuacao findOne(Integer id) {
        return areaAtuacaoRepository.findOne(id);
    }

    public AreaAtuacao save(AreaAtuacao activityarea) {
        return areaAtuacaoRepository.saveAndFlush(activityarea);
    }

    public void delete(Integer id) {
        areaAtuacaoRepository.delete(id);
    }
}
