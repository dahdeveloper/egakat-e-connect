package com.egakat.econnect.maestros.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.services.crud.impl.CrudServiceImpl;
import com.egakat.econnect.maestros.domain.Pais;
import com.egakat.econnect.maestros.dto.PaisDto;
import com.egakat.econnect.maestros.repository.PaisRepository;
import com.egakat.econnect.maestros.service.api.PaisCrudService;

import lombok.val;

@Service
public class PaisCrudServiceImpl extends CrudServiceImpl<Pais, PaisDto, Long> implements PaisCrudService {

	@Autowired
	private PaisRepository repository;

	@Override
	protected PaisRepository getRepository() {
		return repository;
	}

	@Override
	protected PaisDto asModel(Pais entity) {
		val result = newModel();
		mapModel(entity, result);

		result.setCodigo(entity.getCodigo());
		result.setNombre(entity.getNombre());
		result.setCx(entity.getCx());
		result.setCy(entity.getCy());
		result.setOrdinal(entity.getOrdinal());
		result.setActivo(entity.isActivo());

		return result;
	}

	@Override
	protected PaisDto newModel() {
		return new PaisDto();
	}
	
	@Override
	protected Pais mergeEntity(PaisDto model, Pais entity) {

		entity.setCodigo(model.getCodigo());
		entity.setNombre(model.getNombre());
		entity.setCx(model.getCx());
		entity.setCy(model.getCy());
		entity.setOrdinal(model.getOrdinal());
		entity.setActivo(model.isActivo());

		return entity;
	}

	@Override
	protected Pais newEntity() {
		return new Pais();
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public Optional<PaisDto> findByCodigo(String codigo) {
		val optional = getRepository().findByCodigo(codigo);
		val result = asModel(optional);
		return result;
	}
}