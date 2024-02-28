package com.example.unibelltestech.dto;

import java.util.List;

public class ClientDto {
    private Long id;
    private String fullName;
    private List<ContactDto> contacts;

    public ClientDto() {
    }

    public ClientDto(Long id, String fullName, List<ContactDto> contacts) {
        this.id = id;
        this.fullName = fullName;
        this.contacts = contacts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<ContactDto> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactDto> contacts) {
        this.contacts = contacts;
    }
}
