package br.com.facol.uservault.service;

import br.com.facol.uservault.convertes.UserCreateToUserCreateResponseDTO;
import br.com.facol.uservault.domain.UserCreate;
import br.com.facol.uservault.dto.UserCreateRequestDTO;
import br.com.facol.uservault.dto.UserCreateResponseDTO;
import br.com.facol.uservault.repository.UserCreateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCreateServiceImpl implements UserCreateService {

    private final UserCreateRepository repository;
    private final UserCreateToUserCreateResponseDTO converter;

    public UserCreateServiceImpl(UserCreateRepository repository, UserCreateToUserCreateResponseDTO converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public List<UserCreate> findAll() {
        return repository.findAll();
    }

    @Override
    public UserCreateResponseDTO create(UserCreateRequestDTO userCreateRequestDTO) {

        UserCreate userCreate = new UserCreate();
        userCreate.setName(userCreateRequestDTO.getName());
        userCreate.setEmail(userCreateRequestDTO.getEmail());


        UserCreate userCreated = repository.save(userCreate);

        return converter.map(userCreated);
    }
}
