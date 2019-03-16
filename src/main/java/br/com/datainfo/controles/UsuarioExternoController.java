package br.com.datainfo.controles;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.datainfo.entidades.UsuarioExterno;
import br.com.datainfo.repositorios.UsuarioExternoRepository;
import br.com.datainfo.servicos.UsuarioExternoService;

@RestController
@RequestMapping(value = "/usuario-externo")
public class UsuarioExternoController {

	@Autowired
	private UsuarioExternoRepository repository;

	@Autowired
	private UsuarioExternoService service;

	@GetMapping
	public ResponseEntity<List<UsuarioExterno>> listaUsuariosExterno() {
		return ResponseEntity.ok(repository.findAll());
	}

	@PostMapping
	public ResponseEntity<?> incluirUsuario(@RequestBody @Valid UsuarioExterno usuarioExterno) {
		try {
			return ResponseEntity.ok(service.incluirUsuario(usuarioExterno));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping(value = "/{nuCpf}")
	public ResponseEntity<?> excluirUsuario(@PathVariable String nuCpf) {
		try {
			service.excluirUsuario(nuCpf);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping(value = "/{nuCpf}/habilita-desabilita")
	public ResponseEntity<?> habilitaDesabilitaUsuario(@PathVariable String nuCpf) {
		try {
			return ResponseEntity.ok().body(service.habilitaDesabilitaUsuario(nuCpf));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
