package br.com.datainfo.dto;

public class UsuarioExternoFilter {

	private String situacao;
	private String perfil;
	private String nome;

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
