package ufjf.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufjf.br.models.AgendamentoUsuario;
import ufjf.br.models.PreAtendimento;
import ufjf.br.repository.AgendamentoUsuarioRepository;
import ufjf.br.repository.PreAtendimentoRepository;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AgendamentoUsusarioService {

    @Autowired
    private AgendamentoUsuarioRepository agendamentoUsuarioRepository;
    


    public List<AgendamentoUsuario> findAll()
    {
        return agendamentoUsuarioRepository.findAll();
    }

    public List<AgendamentoUsuario> findAllByOrderById()
    {
        return agendamentoUsuarioRepository.findAllByOrderById();
    }

    public AgendamentoUsuario findOne(Integer id)
    {
        return agendamentoUsuarioRepository.findOne(id);
    }

    public AgendamentoUsuario save(AgendamentoUsuario agendamentoUsuario)
    {
        return agendamentoUsuarioRepository.saveAndFlush(agendamentoUsuario);
    }

    public void delete(Integer id)
    {
        agendamentoUsuarioRepository.delete(id);
    }
    
//   public ArrayList<String> geraHorario(){
//
//        List<AgendamentoUsuario> datas = agendamentoUsuarioRepository.findAllByOrderById();
//        ArrayList<String> horarios = new ArrayList<String>();
//
//       SimpleDateFormat formatar = new SimpleDateFormat("dd'-'MM'-'yyyy' 'k':'mm':'ss");
//        String aux;
//
//        for (AgendamentoUsuario i : datas)
//        {
//            aux = String.valueOf(i.getControleHorarios().getPreAtendimento().getDataInicial());
//            aux = formatar.format(aux);
//
//            horarios.add(aux);
//
//        }
//
//        return horarios;
//    }
}
