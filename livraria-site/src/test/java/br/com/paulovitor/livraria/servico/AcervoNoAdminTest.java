package br.com.paulovitor.livraria.servico;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class AcervoNoAdminTest {

	@Test
	public void converteUmaListaComApenasUmLivro() {
		ClienteHTTP http = mock(ClienteHTTP.class);
		when(http.get(anyString())).thenReturn(
				"<livros>" + "<livro>" + "<titulo>VRaptor 3</titulo>"
						+ "<isbn>12345</isbn>" + "</livro>" + "</livros>");
	}

}
