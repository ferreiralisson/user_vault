package br.com.facol.uservault.controller;

import br.com.facol.uservault.domain.UserCreate;
import br.com.facol.uservault.dto.UserCreateRequestDTO;
import br.com.facol.uservault.dto.UserCreateResponseDTO;
import br.com.facol.uservault.service.UserCreateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserCreateController {

    // TODO: implementar: Builder, Adapter e Command

    private final UserCreateService service;

    public UserCreateController(UserCreateService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserCreateResponseDTO> create(@RequestBody UserCreateRequestDTO userCreateRequestDTO){
        UserCreateResponseDTO response = service.create(userCreateRequestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserCreateResponseDTO>> listAll(){
        List<UserCreateResponseDTO> users = service.findAll();
        return ResponseEntity.ok(users);
    }

}
