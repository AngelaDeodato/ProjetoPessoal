package br.com.itau.mercadoLivre.Dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.itau.mercadoLivre.Model.Usuario;

public class UsuarioDto {
	
	private Long id;
	private String login;
	private LocalDateTime cadastradoEm;

	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.login = usuario.getLogin();
		this.cadastradoEm = usuario.getCadastradoEm();
	}

	public Long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public LocalDateTime getCadastradoEm() {
		return cadastradoEm;
	}

	public static List<UsuarioDto> converter(List<Usuario> usuarios) {
		return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}
}
