package br.com.itau.mercadoLivre.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.itau.mercadoLivre.Model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	Optional<Produto> findByNome(String nomeProduto);

}
