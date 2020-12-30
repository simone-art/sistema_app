package com.example.sistemapp.controller;

import com.example.sistemapp.entity.Conteudo;
import com.example.sistemapp.repository.ConteudoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;



@Controller
public class ConteudoController {

    @Autowired
    private ConteudoRepository cr;

    //@ResponseBody
    //@GetMapping(path = "./conteudoSystem", produces = MediaType.TEXT_HTML_VALUE)
    @RequestMapping(value = "/conteudo", method = RequestMethod.GET)
    public String textarea() {
        return "/conteudo";
    }

    @RequestMapping(value = "/conteudo", method = RequestMethod.POST)
    public String textarea(Conteudo conteudo) {
        //Salva os dados no banco de dados
        cr.save(conteudo);
        contarPalavras(conteudo.getConteudo());
        JOptionPane.showMessageDialog(null, "A aquantidade de palavras é: " + conteudo.getConteudo());
        return "redirect:/conteudo";

    }

    @RequestMapping("/conteudo")
    public ModelAndView ListaConteudos() {
        ModelAndView cmv = new ModelAndView("index");
        Iterable<Conteudo> Conteudos = cr.findAll();
        cmv.addObject("conteudos", Conteudos);
        return cmv;
    }

    public static int contarPalavras(String conteudo) {
        int contador = 1, pos;
        conteudo = conteudo.trim();
        if (conteudo.isEmpty()) {
            contador = 0;
        } else {
            pos = conteudo.indexOf(" ");
            while (pos != -1) {
                contador++;
                pos = conteudo.indexOf(" ", pos + 1);
            }
        }
        return contador;

    }


}