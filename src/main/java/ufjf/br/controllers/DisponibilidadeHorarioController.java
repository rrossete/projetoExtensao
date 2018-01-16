package ufjf.br.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ufjf.br.models.DisponibilidadeHorario;
import ufjf.br.models.Usuario;
import ufjf.br.service.DisponibilidadeHorarioService;
import ufjf.br.service.UsuarioService;

import javax.validation.Valid;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

@Controller
@RequestMapping(value = {"/disponibilidadeHorario"})
public class DisponibilidadeHorarioController {

    @Autowired
    private DisponibilidadeHorarioService disponibildadeHorarioService;
    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = {"index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/disponibilidadeHorario/index");
        List<DisponibilidadeHorario> disponibilidades = disponibildadeHorarioService.findAll();
        mv.addObject("disponibilidades", disponibildadeHorarioService.findAll());

        return mv;
    }

    @GetMapping(value = "create")
    public ModelAndView create() {
        Usuario usuario = new Usuario();

        DisponibilidadeHorario disponibilidade = new DisponibilidadeHorario();

        disponibilidade.setUsuario(usuario);
        ModelAndView mv = new ModelAndView("/disponibilidadeHorario/create");
        mv.addObject("disponibilidadeHorario", disponibilidade);
        return mv;
    }
    @PostMapping(value = "create")
    public ModelAndView create(@ModelAttribute @Valid DisponibilidadeHorario disponibilidadeHorario, BindingResult result) {
        Usuario user = usuarioService.findOne(disponibilidadeHorario.getUsuario().getId());
        disponibilidadeHorario.setUsuario(user);
        Duration duracao = Duration.between(disponibilidadeHorario.getHorario_inicio(),disponibilidadeHorario.getHorario_fim());
        LocalTime cargaHoraria = LocalTime.MIDNIGHT.plus(duracao);
        disponibilidadeHorario.setCargahoraria(cargaHoraria);


        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("/disponibilidadeHorario/create");
            mv.addObject("disponibilidadeHorario", disponibilidadeHorario);

            return mv;
        }

        disponibildadeHorarioService.save(disponibilidadeHorario);

        return new ModelAndView("redirect:/disponibilidadeHorario/index");
    }

    @GetMapping(value = "update/{id}")
    public ModelAndView update(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView("/disponibilidadeHorario/update");
        mv.addObject("disponibilidadeHorario", disponibildadeHorarioService.findOne(id));

        return mv;
    }

    @PostMapping("/update/{id}")
    public ModelAndView save(@PathVariable("id") Integer id, @Valid DisponibilidadeHorario disponibilidade, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("/disponibilidadeHorario/update");
            mv.addObject("disponibilidadeHorario", disponibilidade);

            return mv;
        }

        disponibildadeHorarioService.save(disponibilidade);
        return new ModelAndView("redirect:/disponibilidadeHorario/index");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id) {
        disponibildadeHorarioService.delete(id);
        return new ModelAndView("redirect:/disponibilidadeHorario/index");
    }

    @RequestMapping(value = "/get-usuario/{nome}")
    public @ResponseBody List<Usuario> buscaNome(@PathVariable String nome){
        return usuarioService.findbyName(nome);
    }
}
