package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AuthorInfo(@NotBlank String address, @NotNull String phoneNumber,@NotBlank @Email String email) {
    public AuthorInfo(@JsonProperty("address") String address,
                      @JsonProperty("phoneNumber") String phoneNumber,
                      @JsonProperty("email") String email) {
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
