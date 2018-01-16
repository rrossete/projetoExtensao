package ufjf.br.controllers;

import org.springframework.web.bind.annotation.*;
import ufjf.br.models.Cidade;
import ufjf.br.models.Cliente;
import ufjf.br.models.Endereco;
import ufjf.br.service.CidadeService;
import ufjf.br.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import ufjf.br.service.EnderecoService;
import ufjf.br.service.EstadoService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = {"/cliente"})
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private CidadeService cidadeService;

    @RequestMapping(value = {"index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/cliente/index");
        mv.addObject("clientes", clienteService.findAll());

        return mv;
    }

    @GetMapping(value = "create")
    public ModelAndView create() {
        Cliente model = new Cliente();
        Endereco endereco = new Endereco();
        ModelAndView mv = new ModelAndView("/cliente/create");
        mv.addObject("cliente", model);
        mv.addObject("estados", estadoService.findAllByOrderByNome());
        mv.addObject("cidades", cidadeService.findAllByOrderByNome());

        return mv;
    }

    @PostMapping(value = "create")
    @Transactional
    public ModelAndView create(@ModelAttribute @Valid Cliente cliente, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("/cliente/create", "erros", result.getAllErrors());
            mv.addObject("cliente", cliente);
            mv.addObject("estados", estadoService.findAllByOrderByNome());
            mv.addObject("cidades", cidadeService.findAllByOrderByNome());

            return mv;
        }

        enderecoService.save(cliente.getEndereco());
        clienteService.save(cliente);

        return new ModelAndView("redirect:/cliente/index");
    }

    @GetMapping(value = "update/{id}")
    public ModelAndView update(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView("/cliente/update");
        mv.addObject("cliente", clienteService.findOne(id));
        mv.addObject("estados", estadoService.findAllByOrderByNome());
        mv.addObject("cidades", cidadeService.findAllByOrderByNome());

        return mv;
    }

    @PostMapping("/update/{id}")
    @Transactional
    public ModelAndView save(@PathVariable("id") Integer id, @ModelAttribute @Valid Cliente model, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("/cliente/update");
            mv.addObject("cliente", model);
            mv.addObject("estados", estadoService.findAllByOrderByNome());
            mv.addObject("cidades", cidadeService.findAllByOrderByNome());

            return mv;
        }

        enderecoService.save(model.getEndereco());
        clienteService.save(model);
        return index();
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id) {

        Integer endereco_id = clienteService.findOne(id).getEndereco().getId();
        enderecoService.delete(endereco_id);
        clienteService.delete(id);
        return new ModelAndView("redirect:/cliente/index");
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
