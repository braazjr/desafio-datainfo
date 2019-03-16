package br.com.datainfo.entidades.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.datainfo.entidades.UsuarioExterno;

@Repository
public interface UsuarioExternoRepository extends JpaRepository<UsuarioExterno, String> {

}
