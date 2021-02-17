package br.com.itau.mercadoLivre.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.mercadoLivre.Dto.CategoriaDto;
import br.com.itau.mercadoLivre.Form.CategoriaForm;
import br.com.itau.mercadoLivre.Model.Categoria;
import br.com.itau.mercadoLivre.Repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping
	public void PostCategoria(@RequestBody @Valid CategoriaForm  categoriaForm){
		Categoria categoria = categoriaForm.converter(categoriaRepository);
		categoriaRepository.save(categoria);
	}
	
	@GetMapping
	public List<CategoriaDto> GetAll(){
		List<Categoria> categorias = categoriaRepository.findAll();
		return CategoriaDto.converter(categorias);
	}
}
