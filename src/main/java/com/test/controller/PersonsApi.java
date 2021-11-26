package com.test.controller;


import com.test.dto.request.PersonRequestDto;
import com.test.dto.response.PersonResponseDto;
import com.test.facade.PersonFacade;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonsApi {

  private final PersonFacade personFacade;

  public PersonsApi(PersonFacade personFacade) {
    this.personFacade = personFacade;
  }


  @PostMapping
  public PersonResponseDto savePerson(@RequestBody PersonRequestDto personRequestDto) {
    return this.personFacade.savePerson(personRequestDto);
  }

  @DeleteMapping("delete/{id}")
  public Boolean deletePersonById(@PathVariable Long id) {

    return this.personFacade.deletePerson(id);
  }


  @PostMapping("update-person")
  public PersonResponseDto updatePerson(@RequestBody PersonRequestDto personRequestDto) {

    return this.personFacade.updatePerson(personRequestDto);
  }


}
