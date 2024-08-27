package br.com.facol.uservault.convertes;

import br.com.facol.uservault.domain.UserCreate;
import br.com.facol.uservault.dto.UserCreateResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UserCreateToUserCreateResponseDTO implements Mapper<UserCreate, UserCreateResponseDTO>{
    @Override
    public UserCreateResponseDTO map(UserCreate userCreate) {
        UserCreateResponseDTO userCreateResponseDTO = new UserCreateResponseDTO();
        userCreateResponseDTO.setId(userCreate.getId().toString());
        userCreateResponseDTO.setName(userCreate.getName());
        userCreateResponseDTO.setEmail(userCreate.getEmail());
        return userCreateResponseDTO;
    }
}
