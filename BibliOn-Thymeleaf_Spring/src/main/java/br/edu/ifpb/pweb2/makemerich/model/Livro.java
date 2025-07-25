package br.edu.ifpb.pweb2.makemerich.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numero;
    private String descricao;
    private String tipo;
    private Integer diaFechamento;

    @OneToMany(mappedBy = "lista", cascade = CascadeType.ALL)
    private Set<Favorito> favoritos = new HashSet<Favorito>();

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Livro(Usuario usuario) {
        this.usuario = usuario;
    }

    public BigDecimal getSaldo() {
    BigDecimal total = BigDecimal.ZERO;

    for (Favorito t : this.favoritos) {
        BigDecimal valor = t.getValor();
        Categoria categoria = t.getCategoria();

        if (valor != null && categoria != null && categoria.getNatureza() != null) {
            switch (categoria.getNatureza()) {
                case ENTRADA -> total = total.add(valor);
                case SAIDA -> total = total.subtract(valor);
            }
        }
    }

    return total;
}


    public void addFavorito(Favorito Favorito) {
        this.favoritos.add(Favorito);
        Favorito.setLivro(this);
    }



}
