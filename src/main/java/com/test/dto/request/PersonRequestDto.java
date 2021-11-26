package com.test.dto.request;

import lombok.Data;

@Data
public class PersonRequestDto {

  private Long id;
  private String nombre;
  private String apellido;
  private String documentoIdentidad;
  private Boolean isEmpleado;

}
