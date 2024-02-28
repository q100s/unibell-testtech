package com.example.unibelltestech.dto.mapper;

import com.example.unibelltestech.dto.ContactDto;
import com.example.unibelltestech.dto.CreateContactDto;
import com.example.unibelltestech.model.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {
    public static Contact mapIntoEntity(CreateContactDto dto) {
        Contact entity = new Contact();
        entity.setType(dto.getType());
        entity.setContactValue(dto.getValue());
        return entity;
    }

    public static ContactDto mapIntoDto(Contact entity) {
        ContactDto dto = new ContactDto();
        dto.setId(entity.getId());
        dto.setType(entity.getType());
        dto.setContactValue(entity.getContactValue());
        return dto;
    }
}