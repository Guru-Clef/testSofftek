package com.test.service;

import com.test.dto.request.PersonRequestDto;
import com.test.dto.response.PersonResponseDto;

public interface IPersonService {

  PersonResponseDto savePersonOnDb(PersonRequestDto personRequestDto);

  Boolean deletePersonById(Long id);

  PersonResponseDto updatePerson(PersonRequestDto personRequestDto);

}
