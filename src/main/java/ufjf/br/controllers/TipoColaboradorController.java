package ufjf.br.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ufjf.br.models.TipoColaborador;
import ufjf.br.service.TipoColaboradorService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = {"/tipoColaborador"})
public class TipoColaboradorController {
    @Autowired
    private TipoColaboradorService tipoColaboradorService;

    @RequestMapping(value = {"index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/tipoColaborador/index");
        mv.addObject("colaboradores", tipoColaboradorService.findAll());
        return mv;
    }

    @GetMapping(value = "create")
    public ModelAndView create() {
        TipoColaborador tiposColaborador = new TipoColaborador();
        ModelAndView mv = new ModelAndView("/tipoColaborador/create");
        mv.addObject("tipoColaborador", tiposColaborador);

        return mv;
    }

    @PostMapping(value = "create")
    public ModelAndView create(@Valid TipoColaborador tiposColaborador, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("/tipoColaborador/create");
            mv.addObject("tipoColaborador", tiposColaborador);

            return mv;
        }

        tipoColaboradorService.save(tiposColaborador);

        return new ModelAndView("redirect:/tipoColaborador/index");
    }

    @GetMapping(value = "update/{id}")
    public ModelAndView update(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView("/tipoColaborador/update");
        mv.addObject("tipoColaborador", tipoColaboradorService.findOne(id));

        return mv;
    }

    @PostMapping("/update/{id}")
    public ModelAndView save(@PathVariable("id") Integer id, @Valid TipoColaborador tiposColaborador, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("/tipoColaborador/update");
            mv.addObject("tipoColaborador", tiposColaborador);

            return mv;
        }

        tipoColaboradorService.save(tiposColaborador);
        return index();
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id) {
        tipoColaboradorService.delete(id);
        return new ModelAndView("redirect:/tipoColaborador/index");
    }
}
