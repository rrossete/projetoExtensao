package ufjf.br.controllers;

import ufjf.br.models.AreaAtuacao;
import ufjf.br.service.AreaAtuacaoService;
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
@RequestMapping(value = {"/areaAtuacao"})
public class AreaAtuacaoController {

    @Autowired
    private AreaAtuacaoService areaAtuacaoService;

    @RequestMapping(value = {"index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/areaAtuacao/index");
        mv.addObject("areasatuacao", areaAtuacaoService.findAll());

        return mv;
    }

    @GetMapping(value = "create")
    public ModelAndView create() {
        AreaAtuacao activityarea = new AreaAtuacao();
        ModelAndView mv = new ModelAndView("/areaAtuacao/create");
        mv.addObject("areaAtuacao", activityarea);

        return mv;
    }

    @PostMapping(value = "create")
    public ModelAndView create(@Valid AreaAtuacao activityarea, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("/areaAtuacao/create");
            mv.addObject("areaAtuacao", activityarea);

            return mv;
        }

        areaAtuacaoService.save(activityarea);

        return new ModelAndView("redirect:/areaAtuacao/index");
    }

    @GetMapping(value = "update/{id}")
    public ModelAndView update(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView("/areaAtuacao/update");
        mv.addObject("areaAtuacao", areaAtuacaoService.findOne(id));

        return mv;
    }

    @PostMapping("/update/{id}")
    public ModelAndView save(@PathVariable("id") Integer id, @Valid AreaAtuacao activityarea, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("/areaAtuacao/update");
            mv.addObject("areaAtuacao", activityarea);

            return mv;
        }

        areaAtuacaoService.save(activityarea);
        return new ModelAndView("redirect:/areaAtuacao/index");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id) {
        areaAtuacaoService.delete(id);
        return new ModelAndView("redirect:/areaAtuacao/index");
    }
}
