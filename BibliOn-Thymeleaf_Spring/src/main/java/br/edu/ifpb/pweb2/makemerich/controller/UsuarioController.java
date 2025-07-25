package br.edu.ifpb.pweb2.makemerich.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifpb.pweb2.makemerich.model.Usuario;
import br.edu.ifpb.pweb2.makemerich.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    
    @GetMapping("/form")
    public ModelAndView getForm(Usuario usuario, ModelAndView model) {
        model.addObject("usuario", usuario);
        model.setViewName("usuarios/form");
        return model;
    }

   @PostMapping
    public ModelAndView save(Usuario usuario, ModelAndView model, RedirectAttributes attr) {
        usuarioService.save(usuario);
        attr.addFlashAttribute("mensagem", "Usuario inserido com sucesso!");
        model.setViewName("redirect:usuarios");
        return model;
    }

    @GetMapping
    public ModelAndView listAll(ModelAndView model) {
        model.addObject("usuarios", usuarioService.findAll());
        model.setViewName("usuarios/list");
        return model;
    }

    @GetMapping("/{id}")
    public ModelAndView getUsuarioById(@PathVariable(value = "id") Integer id, ModelAndView model) {
        model.setViewName("usuarios/form");
        model.addObject("usuario", usuarioService.findById(id));
        return model;
    }

    @ModelAttribute("menu")
    public String selectMenu() {
        return "usuario";
    }
}