package br.com.itau.mercadoLivre.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.mercadoLivre.model.Categoria;
import br.com.itau.mercadoLivre.repository.CategoriaRepository;
import br.com.itau.mercadoLivre.request.MetodoConverter;
import br.com.itau.mercadoLivre.request.NovaCategoriaRequest;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> GetAll (){
		return ResponseEntity.ok(categoriaRepository.findAll());
	}
	
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid NovaCategoriaRequest categoriaRequest){
		Categoria categoria = MetodoConverter.ConverteRequestParaCategoria(categoriaRequest);
		categoriaRepository.save(categoria);
		return ResponseEntity.ok().build();
	}

}
