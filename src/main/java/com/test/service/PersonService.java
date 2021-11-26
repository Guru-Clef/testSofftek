package com.test.service;

import com.test.dto.request.PersonRequestDto;
import com.test.dto.response.PersonResponseDto;
import com.test.entity.Person;
import com.test.repository.PersonRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService {

  private PersonRepository personRepository;

  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }


  @Override
  public PersonResponseDto savePersonOnDb(PersonRequestDto personRequestDto) {

    Person personEntity = new Person();
    personEntity.setName(personRequestDto.getNombre());
    personEntity.setLastName(personRequestDto.getApellido());
    personEntity.setDni(personRequestDto.getDocumentoIdentidad());
    personEntity.setIsEmployee(personRequestDto.getIsEmpleado());

    Person savedPerson = personRepository.save(personEntity);
    return new PersonResponseDto(savedPerson.getName(), savedPerson.getLastName(),
        savedPerson.getDni(),
        savedPerson.getIsEmployee());
  }

  @Override
  public Boolean deletePersonById(Long id) {
    try {
      personRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public PersonResponseDto updatePerson(PersonRequestDto personRequestDto) {

    Long personId = personRequestDto.getId();
    Optional<Person> opPerson = personRepository.findById(personId);

    Person personEntity;
    Optional<Person> opUpdatedPersonEntity = Optional.empty();

    if (opPerson.isPresent()) {
      personEntity = opPerson.get();
      personEntity.setName(personRequestDto.getNombre());
      personEntity.setLastName(personRequestDto.getApellido());
      personEntity.setDni(personRequestDto.getDocumentoIdentidad());
      personEntity.setIsEmployee(personRequestDto.getIsEmpleado());

      opUpdatedPersonEntity = Optional.ofNullable(personRepository.save(personEntity));
    }

    if (opUpdatedPersonEntity.isPresent()) {
      Person updatedPerson = opUpdatedPersonEntity.get();
      return new PersonResponseDto(updatedPerson.getName(), updatedPerson.getLastName(),
          updatedPerson.getDni(),
          updatedPerson.getIsEmployee());
    }

    return null;


  }
}
