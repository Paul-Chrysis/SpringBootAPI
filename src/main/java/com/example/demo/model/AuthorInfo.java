package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record AuthorInfo(String address, String phoneNumber, String email) {
    public AuthorInfo(@JsonProperty("address") @NotBlank String address,
                      @JsonProperty("phoneNumber") @NotBlank @Size(min = 10,max = 10) @Positive String phoneNumber,
                      @JsonProperty("email") @NotBlank @Email String email) {
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
