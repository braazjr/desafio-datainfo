package br.com.datainfo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.datainfo.entidades.FuncaoUsuarioExterno;

@Repository
public interface FuncaoUsuarioRepository extends JpaRepository<FuncaoUsuarioExterno, Integer> {

}
