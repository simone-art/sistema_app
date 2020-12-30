package com.example.sistemapp.controller;

import com.example.sistemapp.entity.Conteudo;
import com.example.sistemapp.repository.ConteudoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConteudoController {

    @Autowired
    private ConteudoRepository cr;

    @RequestMapping(value="/conteudo", method= RequestMethod.GET)
    public String textarea(){
        return "conteudo/textareaConteudo";
    }


    @RequestMapping(value="/conteudo", method= RequestMethod.POST)
    public String textarea(Conteudo conteudo){
        //Salva os dados no banco de dados
        cr.save(conteudo);
        return "redirect:/conteudo";
    }

    @RequestMapping("/conteudo")
    public ModelAndView ListaConteudos(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Conteudo>Conteudos = cr.findAll();
        mv.addObject("conteudos", Conteudos);
        return mv;
    }
}
