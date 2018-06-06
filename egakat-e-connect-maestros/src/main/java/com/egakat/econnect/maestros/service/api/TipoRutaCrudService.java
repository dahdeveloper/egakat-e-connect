package com.egakat.econnect.maestros.service.api;

import com.egakat.core.services.crud.api.CrudService;
import com.egakat.core.services.crud.api.QueryByCodigoService;
import com.egakat.econnect.maestros.dto.TipoRutaDto;

public interface TipoRutaCrudService
		extends CrudService<TipoRutaDto, Long>, QueryByCodigoService<TipoRutaDto, Long> {
}