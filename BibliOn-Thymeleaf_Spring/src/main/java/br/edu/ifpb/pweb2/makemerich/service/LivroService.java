package br.edu.ifpb.pweb2.makemerich.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ifpb.pweb2.makemerich.model.Livro;
import br.edu.ifpb.pweb2.makemerich.model.Usuario;
import br.edu.ifpb.pweb2.makemerich.repository.LivroRepository;

@Component
public class LivroService implements Service<Livro, Integer> {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    @Override
    public Livro findById(Integer id) {
        return livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrada"));
    }

    @Override
    public Livro save(Livro livro) {
        Usuario usuario = usuarioService.findById(livro.getUsuario().getId());
        livro.setUsuario(usuario);
        return livroRepository.save(livro);
    }

    
    public Livro findByNumeroWithFavoritos(String nuLivro){
        return livroRepository.findByNumeroWithFavoritos(nuLivro);

    }

    public Livro findByIdWithFavoritos(Integer idLivro) {
        return livroRepository.findByIdWithFavoritos(idLivro);
    }

    public List<Livro> findByUsuarioEmail(String email) {
        return livroRepository.findByUsuarioEmail(email);
    }

    public void deleteById(Integer id) {
        livroRepository.deleteById(id);
   }

   public List<Livro> findByUsuario(Usuario usuario) {
    return livroRepository.findByUsuario(usuario);
}


}
