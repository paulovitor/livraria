package br.com.paulovitor.livraria.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Arquivo {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;

	@Lob
	private byte[] conteudo;
	private String contentType;
	private Calendar dataModificacao;

	public Arquivo(String nome, byte[] conteudo, String contentType,
			Calendar dataModificacao) {
		this.setNome(nome);
		this.setConteudo(conteudo);
		this.setContentType(contentType);
		this.setDataModificacao(dataModificacao);
	}

	Arquivo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public byte[] getConteudo() {
		return conteudo;
	}

	public void setConteudo(byte[] conteudo) {
		this.conteudo = conteudo;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Calendar getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(Calendar dataModificacao) {
		this.dataModificacao = dataModificacao;
	}

}
