package com.example.sistemapp.controller;

import com.example.sistemapp.entity.Usuario;
import com.example.sistemapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository ur;

    @RequestMapping(value="/cadastrarUsuario", method= RequestMethod.GET)
    public String form(){
        return "usuario/formUsuario";
    }


    @RequestMapping(value="/cadastrarUsuario", method= RequestMethod.POST)
    public String form(Usuario usuario){
        //Salva os dados no banco de dados
        ur.save(usuario);
        return "redirect:/cadastrarUsuario";
    }

    @RequestMapping("/usuarios")
    public ModelAndView ListaUsuarios(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Usuario>Usuarios = ur.findAll();
        mv.addObject("usuarios", Usuarios);
        return mv;
    }

}
