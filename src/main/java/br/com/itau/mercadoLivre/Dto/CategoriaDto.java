package br.com.itau.mercadoLivre.Dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.itau.mercadoLivre.Model.Categoria;

public class CategoriaDto {

	private Long id;
	private String nome;
	private Categoria categoriaMae;
	
	public CategoriaDto(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
		this.categoriaMae = categoria.getCategoriaMae();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Categoria getCategoriaMae() {
		return categoriaMae;
	}

	public static List<CategoriaDto> converter(List<Categoria> categorias) {
		return categorias.stream().map(CategoriaDto::new).collect(Collectors.toList());
	}

	
	
}
