package br.edu.ifpb.pweb2.makemerich.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ifpb.pweb2.makemerich.model.Favorito;
import br.edu.ifpb.pweb2.makemerich.repository.FavoritoRepository;

@Component
public class FavoritoService {

    @Autowired
    private FavoritoRepository favoritoRepository;

    public List<Favorito> listarPorLivro(Integer livroId) {
        return favoritoRepository.findByLivroId(livroId);
    }

    public Favorito buscarPorId(Integer id) {
        return favoritoRepository.findById(id).orElseThrow();
    }

    public Favorito salvar(Favorito favorito) {
        return favoritoRepository.save(favorito);
    }

    public void excluir(Integer id) {
        favoritoRepository.deleteById(id);
    }
}
