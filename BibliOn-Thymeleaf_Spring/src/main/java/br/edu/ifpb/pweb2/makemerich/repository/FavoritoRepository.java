package br.edu.ifpb.pweb2.makemerich.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.pweb2.makemerich.model.Favorito;

@Repository
public interface FavoritoRepository extends JpaRepository<Favorito, Integer> {
    List<Favorito> findByLivroId(Integer livroId);

}
