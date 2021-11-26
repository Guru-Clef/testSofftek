package com.test.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PersonResponseDto {

  private String nombre;
  private String apellido;
  private String documentoIdentidad;
  private Boolean empleado;

}
