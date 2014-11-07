package br.com.paulovitor.livraria.modelo;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.inject.Alternative;

@Alternative
public class UmaEstanteQualquer implements Estante {

	@Override
	public void guarda(Livro livro) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Livro> todosOsLivros() {
		Livro vrptor = new Livro();
		vrptor.setIsbn("123-45");
		vrptor.setTitulo("VRaptor 3");
		vrptor.setDescricao("Um livro sobre VRaptor 3");
		Livro arquiterura = new Livro();
		arquiterura.setIsbn("5678-90");
		arquiterura.setTitulo("Arquitetura");
		arquiterura.setDescricao("Um livro sobre arquitetura");
		return Arrays.asList(vrptor, arquiterura);
	}

	@Override
	public Livro buscaPorIsbn(String isbn) {
		return todosOsLivros().get(0);
	}

	@Override
	public boolean existeLivroComTitulo(String titulo) {
		// TODO Auto-generated method stub
		return false;
	}

}
