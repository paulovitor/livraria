package br.com.paulovitor.livraria.servico;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.environment.Property;
import br.com.caelum.vraptor.serialization.xstream.XStreamBuilder;
import br.com.paulovitor.livraria.modelo.Livro;

import com.thoughtworks.xstream.XStream;

public class AcervoNoAdmin implements Acervo {

	private ClienteHTTP http;
	private XStreamBuilder builder;
	@Inject
	@Property("admin.url")
	private String adminUrl;

	@Inject
	public AcervoNoAdmin(ClienteHTTP http, XStreamBuilder builder) {
		this.http = http;
		this.builder = builder;
	}

	@Deprecated
	public AcervoNoAdmin() {
	}

	@Override
	public List<Livro> todosOsLivros() {
		String xml = http.get(adminUrl + "/integracao/listaLivros");

		XStream xstream = builder.xmlInstance();
		xstream.alias("livros", List.class);
		xstream.alias("livro", Livro.class);
		return (List<Livro>) xstream.fromXML(xml);
	}

}
