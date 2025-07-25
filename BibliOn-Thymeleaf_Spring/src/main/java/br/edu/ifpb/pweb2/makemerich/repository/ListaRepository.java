package br.edu.ifpb.pweb2.makemerich.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.pweb2.makemerich.model.Lista;
import br.edu.ifpb.pweb2.makemerich.model.Usuario;

@Repository
public interface ListaRepository extends JpaRepository<Lista, Integer> {
    List<Lista> findByUsuario(Usuario usuario);

    @Query("from Lista c left join fetch c.transacoes t where c.numero = :numero")
    Lista findByNumeroWithTransacoes(String numero);

    @Query("from Lista c left join fetch c.transacoes t where c.id = :id")
    Lista findByIdWithTransacoes(Integer id);

    @Query("select distinct c from Lista c left join fetch c.transacoes t where c.id = :id")
    Lista findDistinctByIdWithTransacoes(Integer id);

    List<Lista> findByUsuarioEmail(String email);

    @Query("SELECT c FROM Lista c LEFT JOIN FETCH c.transacoes t WHERE c.id = :id ORDER BY t.data DESC")
    Lista findByIdWithTransacoesOrdered(@Param("id") Integer id);


}
