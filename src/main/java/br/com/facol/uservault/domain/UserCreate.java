package br.com.facol.uservault.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_create")
public class UserCreate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "userCreate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;

    public UserCreate() {}

    public UserCreate(String name, String email, List<Address> addresses) {
        this.name = name;
        this.email = email;
        this.addresses = addresses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
