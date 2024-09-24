package br.com.facol.uservault.dto;

import java.util.List;

public class UserCreateResponseDTO {

    private String id;
    private String name;
    private String email;
    private List<AddressDTO> address;

    public UserCreateResponseDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<AddressDTO> getAddress() {
        return  address;
    }

    public void setAddress(List<AddressDTO> address) {
        this.address = address;
    }
}
