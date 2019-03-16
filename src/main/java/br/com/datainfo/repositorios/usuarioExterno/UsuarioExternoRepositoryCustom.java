package br.com.datainfo.repositorios.usuarioExterno;

import java.util.List;

import br.com.datainfo.dto.UsuarioExternoFilter;
import br.com.datainfo.entidades.UsuarioExterno;

public interface UsuarioExternoRepositoryCustom {

	List<UsuarioExterno> filtrar(UsuarioExternoFilter filter);
}
