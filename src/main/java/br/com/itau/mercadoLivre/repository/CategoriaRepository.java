package br.com.itau.mercadoLivre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.itau.mercadoLivre.model.Categoria;



@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	
}
