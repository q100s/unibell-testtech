package com.example.unibelltestech.service;

import com.example.unibelltestech.dto.ClientDto;
import com.example.unibelltestech.dto.CreateClientDto;
import com.example.unibelltestech.dto.CreateContactDto;

import java.util.List;

public interface ClientService {
    ClientDto getById(Long clientId);

    ClientDto createClient(CreateClientDto client);

    ClientDto addContactToClient(Long clientId, CreateContactDto newContact);

    List<ClientDto> getAllClients();
}