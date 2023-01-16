package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

import java.util.UUID;
public class Author {
    private final UUID id;
    @NotBlank
    private final String name;
    @NotBlank
    private final String surname;
    @NotBlank
    private String address;

    @NotBlank
    @Size(min = 10,max = 10)
    @Positive
    private String phoneNumber;
    @NotBlank @Email
    private String email;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void updateInfo(String newAddress, String newPhoneNumber, String newEmail){
        this.address = newAddress;
        this.phoneNumber = newPhoneNumber;
        this.email = newEmail;
    }



    public Author(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name,
                  @JsonProperty("surname") String surname,
                  @JsonProperty("address") String address,
                  @JsonProperty("phoneNumber") String phoneNumber,
                  @JsonProperty("email") String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;

    }


}
