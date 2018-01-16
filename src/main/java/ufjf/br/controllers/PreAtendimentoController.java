package ufjf.br.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ufjf.br.models.PreAtendimento;
import ufjf.br.service.PreAtendimentoService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = {"/preAtendimento"})
public class PreAtendimentoController {


    @Autowired
    private PreAtendimentoService preAtendimentoService;

    @RequestMapping(value = {"index", "/"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/preAtendimento/index");
        mv.addObject("preAtendimento", preAtendimentoService.findAll());
        mv.addObject("horarios", preAtendimentoService.geraData());
        return mv;
    }

    @GetMapping(value = "create")
    public ModelAndView create() {
        PreAtendimento model = new PreAtendimento();
        ModelAndView mv = new ModelAndView("/preAtendimento/create");
        mv.addObject("preAtendimento", model);

        return mv;
    }

    @PostMapping(value = "create")
    @Transactional
    public ModelAndView create(@ModelAttribute @Valid PreAtendimento model, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("/preAtendimento/create", "erros", result.getAllErrors());
            mv.addObject("preAtendimento", model);
            return mv;
        }

        List<PreAtendimento> atendimentos = new ArrayList<>();

        Calendar iniCal = Calendar.getInstance();
        iniCal.setTime(model.getDataInicial());
        Calendar endCal = Calendar.getInstance();
        endCal.setTime(model.getDataFinal());

        if (iniCal.getTimeInMillis() > endCal.getTimeInMillis()) {
            iniCal.setTime(model.getDataFinal());
            endCal.setTime(model.getDataInicial());
        }

        do {
            Calendar backupHoraInicial = Calendar.getInstance();
            backupHoraInicial.setTime(model.getDataInicial());

            if (iniCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && iniCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {

                iniCal.set(Calendar.HOUR, backupHoraInicial.get(Calendar.HOUR));

                do {
                    PreAtendimento atendimento = new PreAtendimento();
                    atendimento.setDataInicial(iniCal.getTime());
                    iniCal.add(Calendar.HOUR, model.getDuracaoAtendimento());
                    atendimento.setDataFinal(iniCal.getTime());
                    atendimento.setSemestre(model.getSemestre());

                    atendimentos.add(atendimento);

                } while(model.getDataInicial().getTime() <= model.getDataFinal().getTime());
            }

        } while (iniCal.getTimeInMillis() < endCal.getTimeInMillis());

        //preAtendimentoService.save(model);
        return new ModelAndView("redirect:/preAtendimento/index");

    }

}