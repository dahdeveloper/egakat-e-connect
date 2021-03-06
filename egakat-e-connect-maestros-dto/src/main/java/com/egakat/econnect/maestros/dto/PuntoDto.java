package com.egakat.econnect.maestros.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.egakat.core.domain.InactivableObject;
import com.egakat.core.domain.ObjectWithCode;
import com.egakat.core.dto.AuditableEntityDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class PuntoDto extends AuditableEntityDto<Long> implements ObjectWithCode<Long>, InactivableObject {

	private long idTercero;

	@NotNull
	@Size(max = 20)
	private String codigo;

	@NotNull
	@Size(max = 100)
	private String nombre;

	private long idCiudad;

	@NotNull
	@Size(max = 150)
	private String direccion;

	private Long idDireccion;

	private boolean activo;
}
