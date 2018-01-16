package ufjf.br.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.Validate;
import ufjf.br.models.*;
import ufjf.br.service.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = {"/usuario"})
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CidadeService cidadeService;

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private TipoColaboradorService tipoColaboradorService;

    @Autowired
    private SetorService setorService;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private ColaboradorService colaboradorService;

    @RequestMapping(value = {"index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/usuario/index");
        mv.addObject("usuarios", usuarioService.findAll());
        return mv;
    }

    @GetMapping(value = "create")
    public ModelAndView create() {
        Usuario usuario = new Usuario();
        Endereco endereco = new Endereco();
        ModelAndView mv = new ModelAndView("/usuario/create");
        mv.addObject("usuario", usuario);
        mv.addObject("estados", estadoService.findAllByOrderByNome());
        mv.addObject("setors", setorService.findAll());
        mv.addObject("tipoColaboradors", tipoColaboradorService.findAll());

        return mv;
    }

    @PostMapping(value = "create")
    @Transactional
    public ModelAndView create(@ModelAttribute @Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("/usuario/create", "erros", result.getAllErrors());
            mv.addObject("usuario", usuario);
            mv.addObject("estados", estadoService.findAllByOrderByNome());
            mv.addObject("setors", setorService.findAll());
            mv.addObject("tipoColaboradors", tipoColaboradorService.findAll());

            return mv;
        }

        Colaborador colaborador = usuario.getColaborador();
        usuario.setColaborador(null);

        enderecoService.save(usuario.getEndereco());
        usuarioService.save(usuario);
        if (!colaborador.getOab().isEmpty()) {
            colaborador.setUsuario(usuario);
            colaboradorService.save(colaborador);
        }


        return new ModelAndView("redirect:/usuario/index");
    }


    @GetMapping(value = "update/{id}")
    public ModelAndView update(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView("/usuario/update");
        mv.addObject("usuario", usuarioService.findOne(id));
        mv.addObject("estados", estadoService.findAllByOrderByNome());
        mv.addObject("setors", setorService.findAll());
        mv.addObject("tipoColaboradors", tipoColaboradorService.findAll());

        return mv;
    }

    @PostMapping("/update/{id}")
    @Transactional
    public ModelAndView save(@PathVariable("id") Integer id, @Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("/usuario/update", "erros", result.getAllErrors());
            mv.addObject("usuario", usuario);
            mv.addObject("estados", estadoService.findAllByOrderByNome());
            mv.addObject("setors", setorService.findAll());
            mv.addObject("tipoColaboradors", tipoColaboradorService.findAll());

            return mv;
        }

        Colaborador colaborador = usuario.getColaborador();
        usuario.setColaborador(null);

        enderecoService.save(usuario.getEndereco());
        usuarioService.save(usuario);
        if (!colaborador.getOab().isEmpty()) {
            colaborador.setUsuario(usuario);
            colaboradorService.save(colaborador);
        }

        return new ModelAndView("redirect:/usuario/index");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id) {
        Integer endereco_id = usuarioService.findOne(id).getEndereco().getId();
        usuarioService.delete(id);
        enderecoService.delete(endereco_id);
        return new ModelAndView("redirect:/usuario/index");
    }

    @RequestMapping(value = "/get-cidade/{id}")
    public @ResponseBody
    String GetCidade(@PathVariable("id") Integer id) {
        List<Cidade> cidades = cidadeService.findAllByEstado_Id(id);
        StringBuilder retorno = new StringBuilder("<option value=\"\">Selecione uma Cidade</option>");
        for (Cidade cidade : cidades) {
            retorno.append(String.format("<option value=\"%d\">%s</option>", cidade.getId(), cidade));
        }

        return retorno.toString();
    }
}
