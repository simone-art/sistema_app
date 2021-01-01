package com.example.sistemapp.controller;

import com.example.sistemapp.entity.Conteudo;
import com.example.sistemapp.entity.Usuario;
import com.example.sistemapp.repository.ConteudoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;

import javax.print.Doc;
import javax.swing.*;
import java.util.Scanner;
import java.util.StringTokenizer;

@Controller
public class ConteudoController {

    @Autowired
    private ConteudoRepository cr;

    @RequestMapping(value = "/conteudo", method = RequestMethod.GET)
    public String form() {
        return "/conteudo/conteudoTextarea";
    }

    @RequestMapping(value = "/conteudo", method = RequestMethod.POST)
    public String form(Conteudo conteudo) {
        cr.save(conteudo);
        //contadorPalavras(conteudo.getConteudo());
        //JOptionPane.showMessageDialog(null, "A aquantidade de palavras é: " + conteudo.getConteudo());
        return "redirect:/conteudo";

    }


    @RequestMapping("/conteudos")
    public ModelAndView ListaConteudos() {
        ModelAndView cmv = new ModelAndView("conteudo/conteudoUsuario");
        Iterable<Conteudo> Conteudos = cr.findAll();
        cmv.addObject("conteudos", Conteudos);
        return cmv;
    }



}