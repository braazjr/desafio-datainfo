package br.com.datainfo.repositorios.usuarioExterno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.datainfo.dto.UsuarioExternoFilter;
import br.com.datainfo.entidades.UsuarioExterno;

@Repository
public class UsuarioExternoRepositoryImpl implements UsuarioExternoRepositoryCustom {

	@PersistenceContext
	EntityManager manager;

	@Override
	public List<UsuarioExterno> filtrar(UsuarioExternoFilter filter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<UsuarioExterno> query = builder.createQuery(UsuarioExterno.class);

		Root<UsuarioExterno> usuarioExterno = query.from(UsuarioExterno.class);
		List<Predicate> predicates = new ArrayList<Predicate>();

		if (filter.getNome() != null) {
			predicates.add(builder.like(builder.lower(usuarioExterno.get("noUsuario")),
					"%" + filter.getNome().toLowerCase() + "%"));
		}

		if (filter.getSituacao() != null) {
			predicates.add(builder.equal(usuarioExterno.get("icSituacao"), filter.getSituacao()));
		}

		if (filter.getPerfil() != null) {
			predicates.add(builder.equal(usuarioExterno.get("idPerfilAcesso"), filter.getPerfil()));
		}

		query.where(predicates.toArray(new Predicate[0]));
		query.orderBy(Arrays.asList(builder.asc(usuarioExterno.get("noUsuario"))));

		return manager.createQuery(query).getResultList();
	}

}
