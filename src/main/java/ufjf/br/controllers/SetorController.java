package ufjf.br.controllers;

import ufjf.br.models.Setor;
import ufjf.br.service.SetorService;
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
@RequestMapping(value = {"/setor"})
public class SetorController {
    @Autowired
    private SetorService setorService;

    @RequestMapping(value = {"index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/setor/index");
        mv.addObject("setores", setorService.findAll());

        return mv;
    }

    @GetMapping(value = "create")
    public ModelAndView create() {
        Setor setor = new Setor();
        ModelAndView mv = new ModelAndView("/setor/create");
        mv.addObject("setor", setor);

        return mv;
    }

    @PostMapping(value = "create")
    public ModelAndView create(@Valid Setor setor, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("/setor/create");
            mv.addObject("setor", setor);

            return mv;
        }

        setorService.save(setor);

        return new ModelAndView("redirect:/setor/index");
    }

    @GetMapping(value = "update/{id}")
    public ModelAndView update(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView("/setor/update");
        mv.addObject("setor", setorService.findOne(id));

        return mv;
    }

    @PostMapping("/update/{id}")
    public ModelAndView save(@PathVariable("id") Integer id, @Valid Setor setor, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("/setor/update");
            mv.addObject("setor", setor);

            return mv;
        }

        setorService.save(setor);
        return index();
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id) {
        setorService.delete(id);
        return new ModelAndView("redirect:/setor/index");
    }
}
