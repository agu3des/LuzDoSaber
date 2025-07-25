package br.edu.ifpb.pweb2.makemerich.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ifpb.pweb2.makemerich.model.Usuario;
import br.edu.ifpb.pweb2.makemerich.repository.UsuarioRepository;
import br.edu.ifpb.pweb2.makemerich.util.PasswordUtil;

@Component
public class UsuarioService implements Service<Usuario, Integer>{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario save(Usuario u) {
        u.setSenha(PasswordUtil.hashPassword(u.getSenha()));
       return usuarioRepository.save(u);
    }
    
}