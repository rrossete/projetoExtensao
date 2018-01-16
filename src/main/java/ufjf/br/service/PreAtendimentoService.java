package ufjf.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufjf.br.models.AgendamentoUsuario;
import ufjf.br.models.PreAtendimento;
import ufjf.br.repository.PreAtendimentoRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class PreAtendimentoService {

    @Autowired
    private PreAtendimentoRepository preAtendimentoRepository;

    public List<PreAtendimento> findAll() {
        return preAtendimentoRepository.findAll();
    }
    public PreAtendimento save(PreAtendimento model) { return preAtendimentoRepository.saveAndFlush(model);}

    public ArrayList<String> geraData(){

        ArrayList<String> datas = new ArrayList<>();
        List<PreAtendimento>  horarios =  preAtendimentoRepository.findAllByOrderByDataInicial();

        SimpleDateFormat formataData = new SimpleDateFormat("dd'-'MM'-'yyyy' 'k':'mm':'ss");

        String data;

        for (PreAtendimento i: horarios){

            data = formataData.format(i.getDataFinal());

            datas.add(data);
        }

        return datas;

    }

}