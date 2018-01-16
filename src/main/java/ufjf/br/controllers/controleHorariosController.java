package ufjf.br.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ufjf.br.models.*;
import ufjf.br.service.ClienteService;
import ufjf.br.service.ControleHorariosService;
import ufjf.br.service.PreAtendimentoService;
import javax.transaction.Transactional;
import javax.validation.Valid;



@Controller
@RequestMapping(value = {"/controleHorario/"})
public class controleHorariosController {

    private  Logger logger = Logger.getLogger(controleHorariosController.class);
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private PreAtendimentoService preAtendimentoService;

    @Autowired
    private ControleHorariosService controleHorariosService;


    @RequestMapping(value = {"index"})
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("/controleHorario/index");
        mv.addObject("controleHorarios",controleHorariosService.findAll());
        return mv;
    }

    @GetMapping(value = "create")
    public ModelAndView create(){
        controleHorarios controleH = new controleHorarios();
        Cliente cliente = new Cliente();
        controleH.setCliente(cliente);
        PreAtendimento preAtendimento=new PreAtendimento();
        controleH.setPreAtendimento(preAtendimento);
        ModelAndView mv = new ModelAndView("/controleHorario/create");
        mv.addObject("horario",controleH);
        mv.addObject("preAtendimento",preAtendimentoService.findAll());
        mv.addObject("clientes", clienteService.findAll());
        return mv;
    }

    @PostMapping(value = "create")
    @Transactional
    public ModelAndView create(@ModelAttribute @Valid controleHorarios controleH, BindingResult result){

        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView("/controleHorario/create","erros", result.getAllErrors());
            mv.addObject("horarios",controleH );
            mv.addObject("preAtendimento",preAtendimentoService.findAll());
            mv.addObject("clientes", clienteService.findAll());

            return mv;
        }
        controleHorariosService.save(controleH);

        return new ModelAndView("redirect:/controleHorario/index");
    }

    @GetMapping(value = "update/{id}")
    public ModelAndView update(@PathVariable("id") Integer id){

        controleHorarios horarios = controleHorariosService.findOne(id);
        ModelAndView mv = new ModelAndView("/controleHorarios/update");

        mv.addObject("controleHorarios",horarios);

        return mv;
    }
    @PostMapping("/update/{id}")
    @Transactional
    public ModelAndView save( @PathVariable("id") Integer id, @ModelAttribute @Valid controleHorarios controleHorario, BindingResult result){

        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("/controleHorario/update");
            mv.addObject("controleHorario", controleHorario);

            return mv;
        }
        controleHorariosService.save(controleHorario);
        return index();
    }
    @GetMapping(value = {"/delete/{id}"})
    public ModelAndView delete(@PathVariable("id") Integer id){
        controleHorariosService.delete(id);
        return new ModelAndView("redirect:/controleHorario/index");
    }
    }


