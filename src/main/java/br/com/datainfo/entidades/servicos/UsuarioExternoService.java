package br.com.datainfo.entidades.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.datainfo.entidades.UsuarioExterno;
import br.com.datainfo.entidades.repositorios.UsuarioExternoRepository;

@Service
public class UsuarioExternoService {

	@Autowired
	private UsuarioExternoRepository repository;

	public UsuarioExterno incluirUsuario(UsuarioExterno usuarioExterno) throws Exception {
		if (repository.findByNuCpf(usuarioExterno.getNuCpf()) != null) {
			throw new Exception("Operação não realizada. Usuário já incluído");
		}
		
		return repository.saveAndFlush(usuarioExterno);
	}
}
