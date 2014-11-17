package br.com.paulovitor.livraria.modelo;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class UsuarioLogado implements Serializable {

	private static final long serialVersionUID = 3836560031850490476L;

	private Usuario usuario;

	public void loga(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isLogado() {
		return this.usuario != null;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void desloga() {
		this.usuario = null;
	}

}
