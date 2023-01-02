package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthorInfo(String address, int phoneNumber, String email) {
    public AuthorInfo(@JsonProperty("address") String address,
                      @JsonProperty("phoneNumber") int phoneNumber,
                      @JsonProperty("email") String email) {
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
