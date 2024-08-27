package br.com.facol.uservault.controller;

import br.com.facol.uservault.domain.UserCreate;
import br.com.facol.uservault.dto.AddressDTO;
import br.com.facol.uservault.dto.UserCreateRequestDTO;
import br.com.facol.uservault.dto.UserCreateResponseDTO;
import br.com.facol.uservault.helpers.GetData;
import br.com.facol.uservault.service.UserCreateService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
    public ResponseEntity<List<UserCreate>> listAll(){
        List<UserCreate> users = service.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/cep")
    public ResponseEntity<AddressDTO> getAdreess(){
        RestTemplate restTemplate = new RestTemplate();
        GetData data = new GetData(restTemplate);

        return data.sendRequest(
                "https://cep.awesomeapi.com.br/json/55606195",
                HttpMethod.GET,
                null,
                AddressDTO.class,
                new HttpHeaders()
        );
    }

}
