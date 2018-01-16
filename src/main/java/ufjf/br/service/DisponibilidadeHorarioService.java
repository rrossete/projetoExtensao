package ufjf.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufjf.br.models.DisponibilidadeHorario;
import ufjf.br.repository.DisponibilidadeHorarioRepository;

import java.util.List;

@Service
public class DisponibilidadeHorarioService {
    @Autowired
    private DisponibilidadeHorarioRepository disponibilidadeHorarioRepository;



    public List<DisponibilidadeHorario> findAll() {
        return disponibilidadeHorarioRepository.findAll();
    }

    public DisponibilidadeHorario findOne(Integer id) {
        return disponibilidadeHorarioRepository.findOne(id);
    }

    public DisponibilidadeHorario save(DisponibilidadeHorario disponibilidadeHorario) {
        return disponibilidadeHorarioRepository.saveAndFlush(disponibilidadeHorario);
    }

    public void delete(Integer id) {
        disponibilidadeHorarioRepository.delete(id);
    }
}
