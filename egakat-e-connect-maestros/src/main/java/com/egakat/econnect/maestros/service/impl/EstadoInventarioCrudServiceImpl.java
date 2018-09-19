package com.egakat.econnect.maestros.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.services.crud.impl.CrudServiceImpl;
import com.egakat.econnect.maestros.domain.EstadoInventario;
import com.egakat.econnect.maestros.dto.EstadoInventarioDto;
import com.egakat.econnect.maestros.repository.EstadoInventarioRepository;
import com.egakat.econnect.maestros.service.api.EstadoInventarioCrudService;

import lombok.val;

@Service
public class EstadoInventarioCrudServiceImpl extends CrudServiceImpl<EstadoInventario, EstadoInventarioDto, String>
		implements EstadoInventarioCrudService {

	@Autowired
	private EstadoInventarioRepository repository;

	@Override
	protected EstadoInventarioRepository getRepository() {
		return repository;
	}

	@Override
	protected EstadoInventarioDto asModel(EstadoInventario entity) {
		// @formatter:off
		val result = EstadoInventarioDto
				.builder()
				.id(entity.getId())
				.nombre(entity.getNombre())
				.descripcion(entity.getDescripcion())
				.ordinal(entity.getOrdinal())
				.activo(entity.isActivo())
				.version(entity.getVersion())
				.creadoPor(entity.getCreadoPor())
				.fechaCreacion(entity.getFechaCreacion())
				.modificadoPor(entity.getModificadoPor())
				.fechaModificacion(entity.getFechaModificacion())

				.build();
		// @formatter:on
		return result;
	}

	@Override
	protected EstadoInventario mergeEntity(EstadoInventarioDto model, EstadoInventario entity) {

		entity.setId(model.getId());
		entity.setNombre(model.getNombre());
		entity.setDescripcion(model.getDescripcion());
		entity.setOrdinal(model.getOrdinal());
		entity.setActivo(model.isActivo());

		return entity;
	}

	@Override
	protected EstadoInventario newEntity() {
		return new EstadoInventario();
	}
}