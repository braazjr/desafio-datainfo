package br.com.datainfo.servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.datainfo.entidades.UsuarioExterno;
import br.com.datainfo.repositorios.UsuarioExternoRepository;

@Service
public class UsuarioExternoService {

	@Autowired
	private UsuarioExternoRepository repository;

	public UsuarioExterno incluirUsuario(UsuarioExterno usuarioExterno) throws Exception {
		if (repository.findByNuCpf(usuarioExterno.getNuCpf()).isPresent()) {
			throw new Exception("Operação não realizada. Usuário já incluído");
		}

		return repository.saveAndFlush(usuarioExterno);
	}

	public void excluirUsuario(String nuCpf) throws Exception {
		Optional<UsuarioExterno> usuarioExterno = repository.findByNuCpf(nuCpf);

		if (!usuarioExterno.isPresent()) {
			throw new Exception("Usuário não encontrado");
		}

		repository.delete(usuarioExterno.get());
	}

	public UsuarioExterno habilitaDesabilitaUsuario(String nuCpf) throws Exception {
		UsuarioExterno usuarioExterno = buscaUsuario(nuCpf);

		if (usuarioExterno.getIcSituacao().equals("A")) {
			repository.desativaUsuario(usuarioExterno.getNuCpf());
		} else {
			repository.ativaUsuario(usuarioExterno.getNuCpf());
		}

		return buscaUsuario(nuCpf);
	}

	private UsuarioExterno buscaUsuario(String nuCpf) throws Exception {
		Optional<UsuarioExterno> usuarioExterno = repository.findByNuCpf(nuCpf);

		if (!usuarioExterno.isPresent()) {
			throw new Exception("Usuário não encontrado");
		}

		return usuarioExterno.get();
	}
}
