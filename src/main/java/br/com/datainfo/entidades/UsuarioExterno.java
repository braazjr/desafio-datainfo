package br.com.datainfo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "usuario_externo")
public class UsuarioExterno {

	@Id
	@Column(name = "nu_cpf")
	@Length(max = 11, message = "O campo cpf pode ter até 11 caracteres!")
	@NotBlank(message = "O campo cpf é obrigatório!")
	private String nuCpf;

	@Column(name = "no_usuario")
	@Length(max = 60, message = "O campo usuário pode ter até 60 caracteres!")
	@NotBlank(message = "O campo usuário é obrigatório!")
	private String noUsuario;

	@Column(name = "de_email")
	@Length(max = 255, message = "O campo email pode ter até 255 caracteres!")
	@NotBlank(message = "O campo email é obrigatório!")
	private String deEmail;

	@Column(name = "ic_situacao")
	@NotBlank(message = "O campo situacao é obrigatório!")
	private String icSituacao;

	@Column(name = "ic_perfil_acesso")
	@NotNull(message = "O campo perfil acesso é obrigatório!")
	private int idPerfilAcesso;

	@ManyToOne
	@JoinColumn(name = "co_funcao")
	@NotNull(message = "O campo funcao usuario externo é obrigatório!")
	private FuncaoUsuarioExterno funcaoUsuarioExterno;

	@Column(name = "nu_telefone")
	@Length(max = 11, message = "O campo telefone pode ter até 11 caracteres!")
	@NotBlank(message = "O campo telefone é obrigatório!")
	private String nuTelefone;

	public String getNuCpf() {
		return nuCpf;
	}

	public void setNuCpf(String nuCpf) {
		this.nuCpf = nuCpf;
	}

	public String getNoUsuario() {
		return noUsuario;
	}

	public void setNoUsuario(String noUsuario) {
		this.noUsuario = noUsuario;
	}

	public String getDeEmail() {
		return deEmail;
	}

	public void setDeEmail(String deEmail) {
		this.deEmail = deEmail;
	}

	public String getIcSituacao() {
		return icSituacao;
	}

	public void setIcSituacao(String icSituacao) {
		this.icSituacao = icSituacao;
	}

	public int getIdPerfilAcesso() {
		return idPerfilAcesso;
	}

	public void setIdPerfilAcesso(int idPerfilAcesso) {
		this.idPerfilAcesso = idPerfilAcesso;
	}

	public FuncaoUsuarioExterno getFuncaoUsuarioExterno() {
		return funcaoUsuarioExterno;
	}

	public void setFuncaoUsuarioExterno(FuncaoUsuarioExterno funcaoUsuarioExterno) {
		this.funcaoUsuarioExterno = funcaoUsuarioExterno;
	}

	public String getNuTelefone() {
		return nuTelefone;
	}

	public void setNuTelefone(String nuTelefone) {
		this.nuTelefone = nuTelefone;
	}

}
