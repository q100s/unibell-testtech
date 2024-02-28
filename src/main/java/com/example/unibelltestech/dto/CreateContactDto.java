package com.example.unibelltestech.dto;

import com.example.unibelltestech.model.Contact.ContactType;

public class CreateContactDto {
    private ContactType type;
    private String value;

    public CreateContactDto() {
    }

    public CreateContactDto(ContactType type, String value) {
        this.type = type;
        this.value = value;
    }

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}