package com.example.unibelltestech.dto;


public class CreateClientDto {
    private String fullName;

    public CreateClientDto() {
    }

    public CreateClientDto(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
