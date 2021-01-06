package com.example.sistemapp.controller;

import com.example.sistemapp.entity.Usuario;
import com.example.sistemapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository ur;

    @RequestMapping(value = "/cadastrarUsuario", method = RequestMethod.GET)
    public String form() {
        return "usuario/formUsuario";
    }


    @RequestMapping(value = "/cadastrarUsuario", method = RequestMethod.POST)
    public String form(@Valid Usuario usuario) {
         ur.save(usuario);
         return "redirect:/cadastrarUsuario";
    }


//   @RequestMapping(value = "/cadastrarUsuario", method = RequestMethod.POST)
//    public String form(@Valid Usuario usuario, BindingResult bindingResul, RedirectAttributes attributes) {
//        if (bindingResul.hasErrors()) {
//            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
//            return "redirect:/cadastrarUsuario";
//        }
//        else {
//            ur.save(usuario);
//            attributes.addFlashAttribute("mensagem", "Cadastro feito com sucesso!");
//            return "redirect:/conteudo";
//
//        }
//    }


    @RequestMapping("/usuarios")
    public ModelAndView ListaUsuarios(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Usuario>Usuarios = ur.findAll();
        mv.addObject("usuarios", Usuarios);
        return mv;
    }

    @GetMapping("/deletar/{codigo}")
    public String deletarUsuario(@PathVariable long codigo){
        Usuario usuario = ur.findByCodigo(codigo);
        ur.delete(usuario);
        return "redirect:/usuarios";
    }


    // Cadastro Usuario edit
//    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
//    public ModelAndView editarUsuario(long codigo) {
//        Usuario usuario = ur.findByCodigo(codigo);
//        ModelAndView mv = new ModelAndView("usuario/index");
//        mv.addObject("usuario", usuario);
//        return mv;
//    }

//    @RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
//    public String deletarUsuario(@PathVariable long codigo, Usuario usuario, RedirectAttributes attributes) {
//        ur.delete(usuario);
//        attributes.addFlashAttribute("success", "Usuário deletado com sucesso!");
//        return "redirect:/cadastrarUsuario";
//    }


//    @RequestMapping ("/usuarios/{id}")
//    public String deletarUsuario( long codigo){
//        Usuario usuario = ur.findByCodigo(codigo);
//        ur.delete(usuario);
//        return "redirect:/cadastrarUsuario";
//    }
//



}


