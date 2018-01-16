package ufjf.br.controllers;


import ufjf.br.models.DemandaJuridica;
import ufjf.br.service.DemandaJuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = {"/demandaJuridica"})
public class DemandaJuridicaController {
    @Autowired
    private DemandaJuridicaService demandaService;

    @RequestMapping(value = {"/index"})
    public ModelAndView index()
    {
        ModelAndView mv = new ModelAndView("/demandaJuridica/index");
        mv.addObject("demandas", demandaService.findAll());

        return mv;
    }

    @GetMapping(value = "create")
    public ModelAndView create(){
        DemandaJuridica demandaJuridica = new DemandaJuridica();
        ModelAndView mv = new ModelAndView("/demandaJuridica/create");
        mv.addObject("demanda", demandaJuridica);

        return mv;

    }

    @PostMapping(value = "create")
    public ModelAndView create(@Valid DemandaJuridica demandaJuridica, BindingResult result)
    {
        if (result.hasErrors()){
            ModelAndView mv = new ModelAndView("demandaJuridica/create");
            mv.addObject("demanda", demandaJuridica);

            return mv;
        }

        demandaService.save(demandaJuridica);

        return new ModelAndView("redirect:/demandaJuridica/index");
    }

    @GetMapping(value = "update/{id}")
    public ModelAndView update (@PathVariable("id") Integer id){

        ModelAndView mv = new ModelAndView("/demandaJuridica/update");
        mv.addObject("demanda", demandaService.findOne(id));

        return mv;

    }

    @PostMapping("/update/{id}")
    public ModelAndView save(@PathVariable("id") Integer id, @Valid DemandaJuridica demandaJuridica, BindingResult result)
    {
        if(result.hasErrors())
        {
            ModelAndView mv = new ModelAndView("/demandaJuridica/update");
            mv.addObject("demada", demandaJuridica);

            return mv;
        }

        demandaService.save(demandaJuridica);

        return index();
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete (@PathVariable("id") Integer id){
        demandaService.delete(id);
        return new ModelAndView("redirect:/demandaJuridica/index");
    }
}
