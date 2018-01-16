package ufjf.br.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ufjf.br.models.*;
import ufjf.br.service.AgendamentoUsusarioService;
import ufjf.br.service.ControleHorariosService;
import ufjf.br.service.DemandaJuridicaService;
import ufjf.br.service.UsuarioService;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Controller
@RequestMapping(value = {"/agendamento-usuario", "/"})
public class AgendamentoUsuarioController {

    @Autowired
    private AgendamentoUsusarioService agendamentoUsusarioService;

    @Autowired
    private ControleHorariosService controleHorariosService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private DemandaJuridicaService demandaJuridicaService;

    @RequestMapping(value = {"index"})
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("/agendamento-usuario/index");
        mv.addObject("agendamento",agendamentoUsusarioService.findAll());
       // mv.addObject("horarios",agendamentoUsusarioService.geraHorario() );
        mv.addObject("controleHorarios",controleHorariosService.findAllByOrderByPreAtendimento()); //Pode ser que aqui de problema na hora dos teste
        return mv;
    }

    @GetMapping(value = {"create"})
    public ModelAndView create(){
        AgendamentoUsuario agendamentoUsuario= new AgendamentoUsuario();
        agendamentoUsuario.setUsuario1(new Usuario());
        agendamentoUsuario.setUsuario2(new Usuario());
        agendamentoUsuario.setDemandaJuridica(new DemandaJuridica());
        agendamentoUsuario.setControleHorarios(new controleHorarios());
        ModelAndView mv = new ModelAndView("/agendamento-usuario/create");
        mv.addObject("agendamento",agendamentoUsuario);
        mv.addObject("usuarios", usuarioService.findAll());
        mv.addObject("demandaJuridicas", demandaJuridicaService.findAll());
        mv.addObject("controleHorarios", controleHorariosService.findAll());//pode ser que aqui tbm de problema

        return mv;
    }

    @PostMapping(value = {"create"})
    @Transactional
    public ModelAndView create(@ModelAttribute @Valid AgendamentoUsuario agendamentoUsuario, BindingResult result){

        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView("/agendamento-usuario/create","erros", result.getAllErrors());
            mv.addObject("agendamento",agendamentoUsuario);
            mv.addObject("usuarios", usuarioService.findAll());
            mv.addObject("demandaJuridicas", demandaJuridicaService.findAll());
            mv.addObject("controleHorarios", controleHorariosService.findAll());

            return mv;
        }

        agendamentoUsusarioService.save(agendamentoUsuario);

        return new ModelAndView("redirect:/agendamento-usuario/index");
    }

    @GetMapping(value = {"/delete/{id}"})
    public ModelAndView delete(@PathVariable("id") Integer id){
        agendamentoUsusarioService.delete(id);
        return new ModelAndView("redirect:/agendamento-usuario/index");
    }


}
