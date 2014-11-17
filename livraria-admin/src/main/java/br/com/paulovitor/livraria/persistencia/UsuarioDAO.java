package br.com.paulovitor.livraria.persistencia;

import br.com.paulovitor.livraria.modelo.Usuario;

public interface UsuarioDAO {

	Usuario buscaPorLoginESenha(String login, String senha);

}
