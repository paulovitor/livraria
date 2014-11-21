package br.com.paulovitor.livraria.controller;

import java.io.IOException;
import java.net.URI;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.download.Download;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.caelum.vraptor.validator.Validator;
import br.com.paulovitor.livraria.modelo.Arquivo;
import br.com.paulovitor.livraria.modelo.ArquivoDownload;
import br.com.paulovitor.livraria.modelo.Diretorio;
import br.com.paulovitor.livraria.modelo.Estante;
import br.com.paulovitor.livraria.modelo.Livro;

import com.google.common.io.ByteStreams;

@Controller
public class LivrosController {

	private Estante estante;
	private Result result;
	private Validator validator;
	private Diretorio imagens;

	@Inject
	public LivrosController(Estante estante, Diretorio imagens, Result result,
			Validator validator) {
		this.estante = estante;
		this.imagens = imagens;
		this.result = result;
		this.validator = validator;
	}

	/**
	 * @deprecated Apenas para o CDI. Não precisa ser público
	 */
	LivrosController() {
	}

	@Get
	@Path(value = "livros/formulario", priority = Path.HIGH)
	public void formulario() {
	}

	@Get("/livros")
	public List<Livro> lista() {
		return estante.todosOsLivros();
	}

	@Transactional
	@Post("/livros")
	public void salva(Livro livro, UploadedFile capa) throws IOException {
		validator.validate(livro);
		validator.onErrorRedirectTo(this).formulario();

		if (capa != null) {
			URI imagemCapa = imagens.grava(new Arquivo(capa.getFileName(),
					ByteStreams.toByteArray(capa.getFile()), capa
							.getContentType(), Calendar.getInstance()));
			livro.setCapa(imagemCapa);
		}

		estante.guarda(livro);

		result.include("mensagem", "Livro salvo com sucesso!");
		result.redirectTo(this).lista();
	}

	@Get
	@Path(value = "/livros/{isbn}", priority = Path.LOW)
	public void edita(String isbn) {
		Livro livroEncontrado = estante.buscaPorIsbn(isbn);
		if (livroEncontrado == null) {
			result.notFound();
		} else {
			result.include(livroEncontrado);
			result.of(this).formulario();
		}
	}

	@Get("/livros/{isbn}/capa")
	public Download capa(String isbn) {
		Livro livro = estante.buscaPorIsbn(isbn);

		Arquivo capa = imagens.recupera(livro.getCapa());

		if (capa == null) {
			result.notFound();
			return null;
		}

		return new ArquivoDownload(capa);
	}
	
	@Delete("/livro/{isbn}")
	public void remove(String isbn) {
		Livro livro = estante.buscaPorIsbn(isbn);
		
		estante.retira(livro);
		
		result.nothing();
	}

}
