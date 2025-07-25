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
import br.edu.ifpb.pweb2.makemerich.model.Livro;
import br.edu.ifpb.pweb2.makemerich.model.Usuario;
import br.edu.ifpb.pweb2.makemerich.service.CategoriaService;
import br.edu.ifpb.pweb2.makemerich.service.LivroService;
import br.edu.ifpb.pweb2.makemerich.service.UsuarioService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/form")
    public ModelAndView getForm(HttpSession session) {
        ModelAndView model = new ModelAndView("livros/form");
        Livro livro = new Livro();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (!usuario.isAdmin()) {
            livro.setUsuario(usuario);
        }

        model.addObject("livro", livro);
        return model;
    }

    @ModelAttribute("usuarioItems")
    public List<Usuario> getUsuarios() {
        return usuarioService.findAll();
    }

    @ModelAttribute("menu")
    public String selectMenu() {
        return "livro";
    }

    @PostMapping
    public ModelAndView save(Livro livro, RedirectAttributes attr, HttpSession session) throws AccessDeniedException {
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (!usuario.isAdmin() &&
                !livro.getUsuario().getId().equals(usuario.getId())) {
            throw new AccessDeniedException("Ação não permitida");
        }

        livroService.save(livro);
        attr.addFlashAttribute("mensagem", "Livro salva com sucesso!");
        return new ModelAndView("redirect:/livros");
    }

    @GetMapping
    public ModelAndView list(HttpSession session) {
        ModelAndView model = new ModelAndView("livros/list");
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        List<Livro> livros = usuario.isAdmin()
                ? livroService.findAll()
                : livroService.findByUsuarioEmail(usuario.getEmail());

        model.addObject("livros", livros);
        return model;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView edit(@PathVariable Integer id) {
        ModelAndView model = new ModelAndView("livros/form");
        model.addObject("livro", livroService.findById(id));
        return model;
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable Integer id, HttpSession session, RedirectAttributes attr) throws AccessDeniedException {
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (!usuario.isAdmin()) {
            throw new AccessDeniedException("Ação não permitida");
        }

        livroService.deleteById(id);
        attr.addFlashAttribute("mensagem", "Livro removida com sucesso!");
        return new ModelAndView("redirect:/livros");
    }
}
