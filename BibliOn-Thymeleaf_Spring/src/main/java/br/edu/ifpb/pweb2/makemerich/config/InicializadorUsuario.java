package br.edu.ifpb.pweb2.makemerich.config;

import br.edu.ifpb.pweb2.makemerich.model.Usuario;
import br.edu.ifpb.pweb2.makemerich.repository.UsuarioRepository;
import br.edu.ifpb.pweb2.makemerich.util.PasswordUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class InicializadorUsuario implements ApplicationRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(ApplicationArguments args) {
        if (usuarioRepository.findByEmail("admin@makemerich.com") == null) {
            Usuario usuario = new Usuario();
            usuario.setNome("Administrador");
            usuario.setEmail("admin@makemerich.com");
            usuario.setSenha(PasswordUtil.hashPassword("123")); 
            usuario.setAdmin(true);

            usuarioRepository.save(usuario);
            System.out.println("Usuario admin inserido com sucesso.");
        } else {
            System.out.println("Usuario admin já existe.");
        }
    }
}