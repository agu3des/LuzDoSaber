package br.edu.ifpb.pweb2.makemerich.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifpb.pweb2.makemerich.model.Usuario;
import br.edu.ifpb.pweb2.makemerich.repository.UsuarioRepository;
import br.edu.ifpb.pweb2.makemerich.util.PasswordUtil;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @GetMapping
    public ModelAndView getForm(ModelAndView model) {
        model.setViewName("auth/login");
        model.addObject("usuario", new Usuario());
        return model;
    }

    @PostMapping
    public ModelAndView valide(Usuario usuario, HttpSession session, ModelAndView model,
            RedirectAttributes redirectAttts) {
        if ((usuario = this.isValido(usuario)) != null) {
            session.setAttribute("usuario", usuario);
            model.setViewName("redirect:/home");
        } else {
            redirectAttts.addFlashAttribute("mensagem", "Login e/ou senha inválidos!");
            model.setViewName("redirect:/auth");
        }
        return model;
    }

    @GetMapping("/logout")
    public ModelAndView logout(ModelAndView mav, HttpSession session) {
        session.invalidate();
        mav.setViewName("redirect:/auth");
        return mav;
    }

    private Usuario isValido(Usuario usuario) {
        Usuario usuarioBD = usuarioRepo.findByEmail(usuario.getEmail());
        boolean valido = false;
        if (usuarioBD != null) {
            if (PasswordUtil.checkPass(usuario.getSenha(), usuarioBD.getSenha())) {
                valido = true;
            }
        }
        return valido ? usuarioBD : null;
    }
}
