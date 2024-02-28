package com.example.unibelltestech.dto;

import com.example.unibelltestech.model.Contact.ContactType;

public class ContactDto {
    private Long id;
    private ContactType type;
    private String contactValue;

    public ContactDto() {
    }

    public ContactDto(Long id, ContactType type, String contactValue) {
        this.id = id;
        this.type = type;
        this.contactValue = contactValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

    public String getContactValue() {
        return contactValue;
    }

    public void setContactValue(String contactValue) {
        this.contactValue = contactValue;
    }
}