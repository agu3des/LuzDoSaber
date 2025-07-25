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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.edu.ifpb.pweb2.makemerich.model.Livro;
import br.edu.ifpb.pweb2.makemerich.model.Usuario;
import br.edu.ifpb.pweb2.makemerich.model.Favorito;
import br.edu.ifpb.pweb2.makemerich.service.CategoriaService;
import br.edu.ifpb.pweb2.makemerich.service.LivroService;
import br.edu.ifpb.pweb2.makemerich.service.FavoritoService;
import jakarta.servlet.http.HttpSession;
@Controller
@RequestMapping("/favoritos")
public class FavoritoController {

    @Autowired
    private FavoritoService favoritoService;

    @Autowired
    private LivroService livroService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/nova/{idLivro}")
    public ModelAndView nova(@PathVariable Integer idLivro, HttpSession session) throws AccessDeniedException {
        Livro livro = livroService.findById(idLivro);
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (!usuario.isAdmin() && !livro.getUsuario().getId().equals(usuario.getId())) {
            throw new AccessDeniedException("Acesso não autorizado");
        }

        Favorito favorito = new Favorito();
        favorito.setLivro(livro);

        ModelAndView mav = new ModelAndView("favoritos/form");
        mav.addObject("livro", livro);
        mav.addObject("favorito", favorito);
        mav.addObject("categorias", categoriaService.buscarAtivasOrdenadas());
        return mav;
    }

    @PostMapping("/salvar")
    public ModelAndView salvar(@ModelAttribute Favorito favorito, RedirectAttributes redirect) {
        Livro livro = livroService.findByIdWithFavoritos(favorito.getLivro().getId());

        if (favorito.getId() == null) {
            livro.addFavorito(favorito);
            livroService.save(livro);
        } else {
            favorito.setLivro(livro);
            favoritoService.salvar(favorito);
        }

        redirect.addFlashAttribute("mensagem", "Transação salva com sucesso!");
        return new ModelAndView("redirect:/favoritos/listar/" + livro.getId());
    }

    @PostMapping("/selecionar")
    public ModelAndView processarSelecao( @RequestParam("nuLivro") Integer idLivro, @RequestParam("acao") String acao, RedirectAttributes redirect) {
        if (acao.equals("nova")) {
            return new ModelAndView("redirect:/favoritos/nova/" + idLivro);
        } else if (acao.equals("listar")) {
            return new ModelAndView("redirect:/favoritos/listar/" + idLivro);
        }

        redirect.addFlashAttribute("mensagem", "Ação inválida");
        return new ModelAndView("redirect:/favoritos");
    }

    @GetMapping("/editar/{idFavorito}")
    public ModelAndView editar(@PathVariable Integer idFavorito, HttpSession session) throws AccessDeniedException {
        Favorito favorito = favoritoService.buscarPorId(idFavorito);
        Livro livro = livroService.findByIdWithFavoritos(favorito.getLivro().getId());
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (!usuario.isAdmin() && !livro.getUsuario().getId().equals(usuario.getId())) {
            throw new AccessDeniedException("Acesso não autorizado");
        }

        ModelAndView mav = new ModelAndView("favoritos/form");
        mav.addObject("livro", livro);
        mav.addObject("favorito", favorito);
        mav.addObject("categorias", categoriaService.buscarAtivasOrdenadas());
        return mav;
    }
    @GetMapping
    public ModelAndView showSelectionForm(HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        if (usuario == null) {
            return new ModelAndView("redirect:/auth/login");
        }

        ModelAndView mav = new ModelAndView("favoritos/form");
        
        if (usuario.isAdmin()) {
            // Admin vê todas as livros
            List<Livro> todasLivros = livroService.findAll();
            mav.addObject("todasLivros", todasLivros);
        } else {
            // Usuário comum vê apenas suas livros
            List<Livro> livrosDoUsuario = livroService.findByUsuario(usuario);
            mav.addObject("livrosDoUsuario", livrosDoUsuario);
        }
        
        return mav;
    }

     @GetMapping("/listar/{idLivro}")
    public ModelAndView listar(@PathVariable Integer idLivro, HttpSession session) throws AccessDeniedException {
        Livro livro = livroService.findByIdWithFavoritos(idLivro);
        
        if (livro == null) {
            ModelAndView mav = new ModelAndView("error");
            mav.addObject("message", "Livro não encontrada!");
            return mav;
        }
        
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        // Verifica se o usuário tem acesso à livro
        if (!usuario.isAdmin() && !livro.getUsuario().getId().equals(usuario.getId())) {
            throw new AccessDeniedException("Acesso não autorizado");
        }

        ModelAndView mav = new ModelAndView("favoritos/list");
        mav.addObject("livro", livro);
        return mav;
    }
}