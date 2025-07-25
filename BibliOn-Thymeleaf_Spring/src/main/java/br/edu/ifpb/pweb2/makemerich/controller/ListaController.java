package br.edu.ifpb.pweb2.makemerich.controller;

import java.nio.file.AccessDeniedException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.edu.ifpb.pweb2.makemerich.model.Lista;
import br.edu.ifpb.pweb2.makemerich.model.Usuario;
import br.edu.ifpb.pweb2.makemerich.service.CategoriaService;
import br.edu.ifpb.pweb2.makemerich.service.ListaService;
import br.edu.ifpb.pweb2.makemerich.service.UsuarioService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/listas")
public class ListaController {

    @Autowired
    private ListaService listaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/form")
    public ModelAndView getForm(HttpSession session) {
        ModelAndView model = new ModelAndView("listas/form");
        Lista lista = new Lista();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (!usuario.isAdmin()) {
            lista.setUsuario(usuario);
        }

        model.addObject("lista", lista);
        return model;
    }

    @ModelAttribute("usuarioItems")
    public List<Usuario> getUsuarios() {
        return usuarioService.findAll();
    }

    @ModelAttribute("menu")
    public String selectMenu() {
        return "lista";
    }

    @PostMapping
    public ModelAndView save(Lista lista, RedirectAttributes attr, HttpSession session) throws AccessDeniedException {
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (!usuario.isAdmin() &&
                !lista.getUsuario().getId().equals(usuario.getId())) {
            throw new AccessDeniedException("Ação não permitida");
        }

        listaService.save(lista);
        attr.addFlashAttribute("mensagem", "Lista salva com sucesso!");
        return new ModelAndView("redirect:/listas");
    }

    @GetMapping
    public ModelAndView list(HttpSession session) {
        ModelAndView model = new ModelAndView("listas/list");
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        List<Lista> listas = usuario.isAdmin()
                ? listaService.findAll()
                : listaService.findByUsuarioEmail(usuario.getEmail());

        model.addObject("listas", listas);
        return model;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView edit(@PathVariable Integer id) {
        ModelAndView model = new ModelAndView("listas/form");
        model.addObject("lista", listaService.findById(id));
        return model;
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable Integer id, HttpSession session, RedirectAttributes attr) throws AccessDeniedException {
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (!usuario.isAdmin()) {
            throw new AccessDeniedException("Ação não permitida");
        }

        listaService.deleteById(id);
        attr.addFlashAttribute("mensagem", "Lista removida com sucesso!");
        return new ModelAndView("redirect:/listas");
    }
}
