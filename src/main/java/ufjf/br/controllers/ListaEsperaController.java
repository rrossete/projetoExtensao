package ufjf.br.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ufjf.br.models.Cliente;
import ufjf.br.models.DemandaJuridica;
import ufjf.br.models.ListaEspera;
import ufjf.br.service.ClienteService;
import ufjf.br.service.DemandaJuridicaService;
import ufjf.br.service.ListaEsperaService;
import org.apache.log4j.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Controller
@RequestMapping(value = {"/listaEspera","/"})
public class ListaEsperaController {


    private  Logger logger = Logger.getLogger(ListaEsperaController.class);

    @Autowired
    private ListaEsperaService listaEsperaService;

    @Autowired
    private DemandaJuridicaService demandaJuridicaService;

    @Autowired
    private ClienteService clienteService;


    @RequestMapping(value = {"index"})
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("/listaEspera/index");
        mv.addObject("listaEsperas",listaEsperaService.findAllByOrderById());

        return mv;
    }

    @GetMapping(value = {"create"})
    public ModelAndView create(){
        ListaEspera listaEspera = new ListaEspera();
        listaEspera.setCliente(new Cliente());
        listaEspera.setDemandaJuridica(new DemandaJuridica());
        ModelAndView mv = new ModelAndView("/listaEspera/create");
        mv.addObject("listaEsperas",listaEspera );
        mv.addObject("demandaJuridicas",demandaJuridicaService.findAll());
        mv.addObject("clientes", clienteService.findAll());


        return mv;
    }

    @PostMapping(value = {"create"})
    @Transactional
    public ModelAndView create(@ModelAttribute @Valid ListaEspera listaEspera, BindingResult result){

        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView("/listaEspera/create","erros", result.getAllErrors());
            mv.addObject("listaEsperas",listaEspera );
            mv.addObject("demandaJuridicas",demandaJuridicaService.findAll());
            mv.addObject("clientes", clienteService.findAll());

            return mv;
        }

        listaEsperaService.save(listaEspera);

        return new ModelAndView("redirect:/listaEspera/index");
    }

    @GetMapping(value = "update/{id}")
    public ModelAndView update(@PathVariable("id") Integer id){

        ListaEspera listaEspera = listaEsperaService.findOne(id);
        ModelAndView mv = new ModelAndView("/listaEspera/update");

        logger.info(listaEspera.hashCode());
        mv.addObject("listaEspera",listaEspera);


        return mv;
    }


    @PostMapping("/update/{id}")
    @Transactional
    public ModelAndView save( @PathVariable("id") Integer id, @ModelAttribute @Valid ListaEspera listaEspera, BindingResult result){

        logger.info(listaEspera.hashCode());
        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("/listaEspera/update");
            mv.addObject("listaEspera", listaEspera);

            return mv;
        }
        //listaEspera.setCliente(clienteService.save(listaEspera.getCliente()));
        listaEsperaService.save(listaEspera);
        return index();
    }




    @GetMapping(value = {"/delete/{id}"})
    public ModelAndView delete(@PathVariable("id") Integer id){
        listaEsperaService.delete(id);
        return new ModelAndView("redirect:/listaEspera/index");
    }






}
