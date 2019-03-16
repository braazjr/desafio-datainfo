package br.com.datainfo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
@Table(name = "funcao_usuario_externo")
public class FuncaoUsuarioExterno {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "co_funcao")
	private Integer coFuncao;

	@Column(name = "no_funcao")
	@Length(max = 50)
	@NotBlank
	private String noFuncao;

	public Integer getCoFuncao() {
		return coFuncao;
	}

	public void setCoFuncao(Integer coFuncao) {
		this.coFuncao = coFuncao;
	}

	public String getNoFuncao() {
		return noFuncao;
	}

	public void setNoFuncao(String noFuncao) {
		this.noFuncao = noFuncao;
	}

	@Override
	public String toString() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
