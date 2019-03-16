package br.com.datainfo.entidades.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.datainfo.entidades.UsuarioExterno;
import br.com.datainfo.entidades.repositorios.UsuarioExternoRepository;

@RestController
@RequestMapping(value = "/usuario-externo")
public class UsuarioExternoController {

	@Autowired
	private UsuarioExternoRepository repo;

	@GetMapping
	public ResponseEntity<List<UsuarioExterno>> listaUsuariosExterno() {
		return ResponseEntity.ok(repo.findAll());
	}
}
