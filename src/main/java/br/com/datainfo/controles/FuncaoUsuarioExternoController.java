package br.com.datainfo.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import br.com.datainfo.entidades.FuncaoUsuarioExterno;
import br.com.datainfo.repositorios.FuncaoUsuarioRepository;

@RestController
@RequestMapping(value = "/funcao-usuario-externo")
public class FuncaoUsuarioExternoController {

	@Autowired
	private FuncaoUsuarioRepository repository;

	@GetMapping
	public ResponseEntity<List<FuncaoUsuarioExterno>> listaFuncaoUsuarioExterno() {
		return ResponseEntity.ok(repository.findAll());
	}
}
