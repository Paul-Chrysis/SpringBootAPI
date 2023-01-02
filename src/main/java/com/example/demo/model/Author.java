package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Author {
    private final UUID id;
    private final String name;
    private final String surname;
    private String address;
    private int phoneNumber;
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

    public int getphoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void updateInfo(String newAddress, int newPhoneNumber, String newEmail){
        this.address = newAddress;
        this.phoneNumber = newPhoneNumber;
        this.email = newEmail;
    }





    public Author(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name,
                  @JsonProperty("surname") String surname,
                  @JsonProperty("address") String address,
                  @JsonProperty("phoneNumber") int phoneNumber,
                  @JsonProperty("email") String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;

    }


}