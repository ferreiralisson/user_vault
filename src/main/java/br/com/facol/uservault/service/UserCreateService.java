package br.com.facol.uservault.service;

import br.com.facol.uservault.domain.UserCreate;
import br.com.facol.uservault.dto.UserCreateRequestDTO;
import br.com.facol.uservault.dto.UserCreateResponseDTO;

import java.util.List;

public interface UserCreateService {

    List<UserCreate> findAll();

    UserCreateResponseDTO create(UserCreateRequestDTO userCreateRequestDTO);
}
