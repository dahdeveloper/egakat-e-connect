package com.egakat.econnect.config.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egakat.core.services.crud.impl.CrudServiceImpl;
import com.egakat.econnect.config.domain.Configuracion;
import com.egakat.econnect.config.dto.ConfiguracionDto;
import com.egakat.econnect.config.repository.ConfiguracionRepository;
import com.egakat.econnect.config.repository.GrupoConfiguracionRepository;
import com.egakat.econnect.config.service.api.ConfiguracionCrudService;

import lombok.val;

@Service
public class ConfiguracionCrudServiceImpl extends CrudServiceImpl<Configuracion, ConfiguracionDto, Long>
		implements ConfiguracionCrudService {

	@Autowired
	private ConfiguracionRepository repository;

	@Autowired
	private GrupoConfiguracionRepository grupoConfiguracionRepository;

	@Override
	protected ConfiguracionRepository getRepository() {
		return repository;
	}

	@Override
	protected ConfiguracionDto asModel(Configuracion entity) {
		val result = newModel();
		mapModel(entity, result);
		
		result.setIdGrupoConfiguracion(entity.getGrupoConfiguracion().getId());
		result.setCodigo(entity.getCodigo());
		result.setValor(entity.getValor());
		result.setActivo(entity.isActivo());
		return result;
	}

	@Override
	protected ConfiguracionDto newModel() {
		return new ConfiguracionDto();
	}

	@Override
	protected Configuracion mergeEntity(ConfiguracionDto model, Configuracion entity) {
		val grupoConfiguracion = grupoConfiguracionRepository.getOne(model.getIdGrupoConfiguracion());

		entity.setGrupoConfiguracion(grupoConfiguracion);
		entity.setCodigo(model.getCodigo());
		entity.setValor(model.getValor());
		entity.setActivo(model.isActivo());

		return entity;
	}

	@Override
	protected Configuracion newEntity() {
		return new Configuracion();
	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public Optional<ConfiguracionDto> findOneByGrupoConfiguracionIdAndCodigo(Long grupoConfiguracion, String codigo) {
		val entity = getRepository().findOneByGrupoConfiguracionIdAndCodigo(grupoConfiguracion, codigo);
		if (entity == null) {
			return Optional.empty();
		}
		val result = asModel(entity);
		return Optional.of(result);
	}

	@Override
	public List<ConfiguracionDto> findAllByGrupoConfiguracionId(long grupoConfiguracion) {
		val entities = getRepository().findAllByGrupoConfiguracionId(grupoConfiguracion);
		val result = asModels(entities);
		return result;
	}
}
