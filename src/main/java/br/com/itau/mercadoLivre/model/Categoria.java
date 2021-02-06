package br.com.itau.mercadoLivre.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;



@Entity
@Table(name = "tb_categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	
	private Long idCategoriaMae;
	
	
	public Categoria() {
		super();
	}

	public Categoria( @NotBlank String nome, Long idCategoriaMae) {
		this.nome = nome;
		this.idCategoriaMae = idCategoriaMae;
	}
	
	

	public Categoria(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Long getIdCategoriaMae() {
		return idCategoriaMae;
	}
	
	
	public static void persiste(EntityManager entity, List<Caracteristicas> caracteristicas) {
		caracteristicas.forEach(Caracteristica -> {
			entity.persist(Caracteristica);
		});
		
	}

}
