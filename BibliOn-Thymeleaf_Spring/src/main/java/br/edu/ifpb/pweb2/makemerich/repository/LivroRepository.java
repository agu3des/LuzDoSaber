package br.edu.ifpb.pweb2.makemerich.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.pweb2.makemerich.model.Livro;
import br.edu.ifpb.pweb2.makemerich.model.Usuario;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
    List<Livro> findByUsuario(Usuario usuario);

    @Query("from Livro c left join fetch c.favoritos t where c.numero = :numero")
    Livro findByNumeroWithFavoritos(String numero);

    @Query("from Livro c left join fetch c.favoritos t where c.id = :id")
    Livro findByIdWithFavoritos(Integer id);

    @Query("select distinct c from Livro c left join fetch c.favoritos t where c.id = :id")
    Livro findDistinctByIdWithFavoritos(Integer id);

    List<Livro> findByUsuarioEmail(String email);

    @Query("SELECT c FROM Livro c LEFT JOIN FETCH c.favoritos t WHERE c.id = :id ORDER BY t.data DESC")
    Livro findByIdWithFavoritosOrdered(@Param("id") Integer id);


}
