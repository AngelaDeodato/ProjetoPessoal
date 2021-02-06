package br.com.itau.mercadoLivre.request;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import br.com.itau.mercadoLivre.model.Categoria;
import br.com.itau.mercadoLivre.validacao.UniqueValue;

//ESSE SERIA O NOSSO DTO
public class NovaCategoriaRequest {

	@NotNull
	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "esse nome já existe")
	private String nome;
	private Long id;
	
	
	
	public String getNome() {
		return nome;
	}
	public Long getId() {
		return id;
	}

	@Deprecated
	public NovaCategoriaRequest() {
	}

	public NovaCategoriaRequest(@NotNull @NotBlank String nome, Long id) {
		super();
		this.nome = nome;
		this.id = id;
	}
	
}
