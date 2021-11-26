package com.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "person")
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "lastname")
  private String lastName;

  @Column(name = "dni")
  private String dni;

  @Column(name = "isemployee")
  private Boolean isEmployee;

}


/*
*
* CREATE TABLE `sofftektest`.`person` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `lastname` VARCHAR(45) NULL,
  `dni` VARCHAR(45) NOT NULL,
  `isemployee` BIT(1) NULL,
  PRIMARY KEY (`id`));
*
* */
