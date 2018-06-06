package com.egakat.econnect.maestros.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import com.egakat.commons.dto.EntityDto;
import com.egakat.core.domain.InactivableObject;
import com.egakat.core.domain.ObjectWithCode;
import com.egakat.core.domain.SortableObject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class TipoRemesaDto extends EntityDto<Long> implements ObjectWithCode<Long>, SortableObject, InactivableObject {

	private static final long serialVersionUID = 1L;

	private long idUnidadNegocio;
	
	@NotNull
	@Size(max = 20)
	private String codigo;

	@NotNull
	@Size(max = 100)
	private String nombre;

	@NotNull
	@Size(max = 200)
	private String descripcion;

	@NumberFormat
	private int ordinal;

	private boolean activo;

	@Builder
	public TipoRemesaDto(Long id, int version, String creadoPor, LocalDateTime fechaCreacion, String modificadoPor,
			LocalDateTime fechaModificacion, long idUnidadNegocio, @NotNull @Size(max = 20) String codigo,
			@NotNull @Size(max = 100) String nombre, @NotNull @Size(max = 200) String descripcion, int ordinal,
			boolean activo) {
		super(id, version, creadoPor, fechaCreacion, modificadoPor, fechaModificacion);
		this.idUnidadNegocio = idUnidadNegocio;
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.ordinal = ordinal;
		this.activo = activo;
	}
}
