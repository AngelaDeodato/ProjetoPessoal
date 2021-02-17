package br.com.itau.mercadoLivre.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.itau.mercadoLivre.Dto.ProdutoDto;
import br.com.itau.mercadoLivre.Form.ImagensForm;
import br.com.itau.mercadoLivre.Form.ProdutoForm;
import br.com.itau.mercadoLivre.Form.Uploader;
import br.com.itau.mercadoLivre.Model.Produto;
import br.com.itau.mercadoLivre.Model.Usuario;
import br.com.itau.mercadoLivre.Repository.CategoriaRepository;
import br.com.itau.mercadoLivre.Repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private Uploader uploader;

	@PostMapping
	public void PostProduto(@RequestBody @Valid ProdutoForm produtoForm, @AuthenticationPrincipal Usuario usuario) {
		Produto produto = produtoForm.converter(categoriaRepository, usuario);
		produtoRepository.save(produto);
	}

	@GetMapping
	public List<ProdutoDto> GetAll() {
		List<Produto> produtos = produtoRepository.findAll();
		return ProdutoDto.converter(produtos);
	}

	@PostMapping("/{id}/imagens")
	public void AddImagens(@PathVariable Long id, @Valid ImagensForm imagensForm,
			@AuthenticationPrincipal Usuario usuario) {
		List<String> links = uploader.envia(imagensForm.getImagens());

		Optional<Produto> produto = produtoRepository.findById(id);

		if (produto.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O produto não existe no sistema!");
		}

		if (produto.get().getUsuario().getId() != usuario.getId()) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"A imagem só pode ser cadastrada pelo seu usuário original!");
		}
		produto.get().associaImagens(links);
		produtoRepository.save(produto.get());
	}
}
