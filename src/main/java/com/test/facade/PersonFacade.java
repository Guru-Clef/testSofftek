package com.test.facade;

import com.test.dto.request.PersonRequestDto;
import com.test.dto.response.PersonResponseDto;
import com.test.service.IPersonService;
import org.springframework.stereotype.Component;

@Component
public class PersonFacade {

  private final IPersonService personService;


  public PersonFacade(IPersonService personService) {
    this.personService = personService;
  }

  public PersonResponseDto savePerson(PersonRequestDto personRequestDto) {
    return this.personService.savePersonOnDb(personRequestDto);
  }

  public Boolean deletePerson(Long id) {
    return this.personService.deletePersonById(id);
  }

  public PersonResponseDto updatePerson(PersonRequestDto personRequestDto) {
    return this.personService.updatePerson(personRequestDto);
  }

}
