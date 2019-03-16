package br.com.datainfo.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.datainfo.entidades.UsuarioExterno;

@Repository
public interface UsuarioExternoRepository extends JpaRepository<UsuarioExterno, String> {

	Optional<UsuarioExterno> findByNuCpf(String nuCpf);

	@Transactional
	@Modifying
	@Query("update UsuarioExterno ue set ue.icSituacao = 'I' where ue.nuCpf = ?1")
	void desativaUsuario(String nuCpf);

	@Transactional
	@Modifying
	@Query("update UsuarioExterno ue set ue.icSituacao = 'A' where ue.nuCpf = ?1")
	void ativaUsuario(String nuCpf);

}
