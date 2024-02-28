package com.example.unibelltestech.dto.mapper;

import com.example.unibelltestech.dto.ClientDto;
import com.example.unibelltestech.dto.CreateClientDto;
import com.example.unibelltestech.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public static Client mapIntoEntity(CreateClientDto dto) {
        Client entity = new Client();
        entity.setFullName(dto.getFullName());
        return entity;
    }

    public static ClientDto mapIntoDto(Client entity) {
        ClientDto dto = new ClientDto();
        dto.setId(entity.getId());
        dto.setFullName(entity.getFullName());
        if (entity.getContacts() != null) {
            dto.setContacts(entity.getContacts().stream()
                    .map(ContactMapper::mapIntoDto)
                    .toList());
        }
        return dto;
    }
}