package br.edu.ifpb.pweb2.makemerich.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ifpb.pweb2.makemerich.model.Lista;
import br.edu.ifpb.pweb2.makemerich.model.Usuario;
import br.edu.ifpb.pweb2.makemerich.repository.ListaRepository;

@Component
public class ListaService implements Service<Lista, Integer> {

    @Autowired
    private ListaRepository listaRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public List<Lista> findAll() {
        return listaRepository.findAll();
    }

    @Override
    public Lista findById(Integer id) {
        return listaRepository.findById(id).orElseThrow(() -> new RuntimeException("Lista não encontrada"));
    }

    @Override
    public Lista save(Lista lista) {
        Usuario usuario = usuarioService.findById(lista.getUsuario().getId());
        lista.setUsuario(usuario);
        return listaRepository.save(lista);
    }

    
    public Lista findByNumeroWithTransacoes(String nuLista){
        return listaRepository.findByNumeroWithTransacoes(nuLista);

    }

    public Lista findByIdWithTransacoes(Integer idLista) {
        return listaRepository.findByIdWithTransacoes(idLista);
    }

    public List<Lista> findByUsuarioEmail(String email) {
        return listaRepository.findByUsuarioEmail(email);
    }

    public void deleteById(Integer id) {
        listaRepository.deleteById(id);
   }

   public List<Lista> findByUsuario(Usuario usuario) {
    return listaRepository.findByUsuario(usuario);
}


}
