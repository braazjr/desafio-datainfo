package br.com.datainfo.entidades.controles;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.datainfo.entidades.UsuarioExterno;
import br.com.datainfo.entidades.repositorios.UsuarioExternoRepository;
import br.com.datainfo.entidades.servicos.UsuarioExternoService;

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
}
