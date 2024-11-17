package br.com.facol.uservault.controller;

import br.com.facol.uservault.dto.UserCreateRequestDTO;
import br.com.facol.uservault.dto.UserCreateResponseDTO;
import br.com.facol.uservault.service.UserCreateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.facol.uservault.helpers.Constants.SECURITY_ROLE_USER;

@RestController
@RequestMapping("/users")
public class UserCreateController {

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
    @PreAuthorize(SECURITY_ROLE_USER)
    public ResponseEntity<List<UserCreateResponseDTO>> listAll(){
        List<UserCreateResponseDTO> users = service.findAll();
        return ResponseEntity.ok(users);
    }

}
