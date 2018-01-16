package ufjf.br.controllers;

import org.springframework.web.bind.annotation.*;
import ufjf.br.models.Colaborador;
import ufjf.br.models.Projeto;
import ufjf.br.models.Usuario;
import ufjf.br.service.ColaboradorService;
import ufjf.br.service.OrgaoFomentoService;
import ufjf.br.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import ufjf.br.service.UsuarioService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping(value = {"/projeto"})
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private ColaboradorService colaboradorService;

    @Autowired
    private OrgaoFomentoService orgaoFomentoService;

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = {"index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/projeto/index");
        mv.addObject("projetos", projetoService.findAll());

        return mv;
    }

    @GetMapping(value = "create")
    public ModelAndView create() {
        Projeto projeto = new Projeto();
        List<Usuario> usuarios = new ArrayList<>();
        ModelAndView mv = new ModelAndView("/projeto/create");
        mv.addObject("projeto", projeto);
        mv.addObject("colaboradors", colaboradorService.findAll());
        mv.addObject("orgaos", orgaoFomentoService.findAll());
        for (Colaborador c : colaboradorService.findAll()){
            if(c.getUsuario() != null)
                usuarios.add(c.getUsuario());
        }
        mv.addObject("users",usuarios);
        return mv;
    }

    @PostMapping(value = "create")
    @Transactional
    public ModelAndView create(@ModelAttribute @Valid Projeto projeto, BindingResult result) {
        if (result.hasErrors()) {
            List<Usuario> usuarios = new ArrayList<>();
            ModelAndView mv = new ModelAndView("/projeto/create", "erros", result.getAllErrors());
            mv.addObject("projeto", projeto);
            mv.addObject("colaboradors", colaboradorService.findAll());
            mv.addObject("orgaos", orgaoFomentoService.findAll());
            for (Colaborador c : colaboradorService.findAll()){
                if(c.getUsuario() != null)
                    usuarios.add(c.getUsuario());
            }
            mv.addObject("users",usuarios);

            return mv;
        }

        projetoService.save(projeto);

        return new ModelAndView("redirect:/projeto/index");
    }

    @GetMapping(value = "update/{id}")
    public ModelAndView update(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView("/projeto/update");
        mv.addObject("projeto", projetoService.findOne(id));
        mv.addObject("colaboradors", colaboradorService.findAll());
        mv.addObject("orgaos", orgaoFomentoService.findAll());
        return mv;
    }

    @PostMapping("/update/{id}")
    public ModelAndView save(@PathVariable("id") Integer id, @ModelAttribute @Valid Projeto projeto, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("/projeto/update");
            mv.addObject("projeto", projeto);
            mv.addObject("colaboradors", colaboradorService.findAll());
            mv.addObject("orgaos", orgaoFomentoService.findAll());
            return mv;
        }

        projetoService.save(projeto);
        return index();
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id) {
        projetoService.delete(id);
        return new ModelAndView("redirect:/projeto/index");
    }
}
