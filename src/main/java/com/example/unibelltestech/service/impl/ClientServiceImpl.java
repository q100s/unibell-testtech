package com.example.unibelltestech.service.impl;

import com.example.unibelltestech.dto.ClientDto;
import com.example.unibelltestech.dto.CreateClientDto;
import com.example.unibelltestech.dto.CreateContactDto;
import com.example.unibelltestech.dto.mapper.ClientMapper;
import com.example.unibelltestech.exception.ClientNotFoundException;
import com.example.unibelltestech.model.Client;
import com.example.unibelltestech.model.Contact;
import com.example.unibelltestech.repository.ClientRepository;
import com.example.unibelltestech.service.ClientService;
import com.example.unibelltestech.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.unibelltestech.dto.mapper.ClientMapper.mapIntoDto;
import static com.example.unibelltestech.dto.mapper.ClientMapper.mapIntoEntity;
import static com.example.unibelltestech.dto.mapper.ContactMapper.mapIntoEntity;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository repository;
    private final ContactService contactService;

    public ClientServiceImpl(ClientRepository repository, ContactService contactService) {
        this.repository = repository;
        this.contactService = contactService;
    }

    @Override
    public ClientDto getById(Long clientId) {
        Client client = repository.findById(clientId).orElseThrow(ClientNotFoundException::new);
        return mapIntoDto(client);
    }

    @Override
    public ClientDto createClient(CreateClientDto client) {
        return mapIntoDto(repository.save(mapIntoEntity(client)));
    }

    @Override
    public ClientDto addContactToClient(Long clientId, CreateContactDto newContact) {
        Client clientToUpdate = repository.findById(clientId).orElseThrow(ClientNotFoundException::new);
        Contact contactToAdd = mapIntoEntity(newContact);
        contactToAdd.setClient(clientToUpdate);
        clientToUpdate.getContacts().add(contactToAdd);
        contactService.createContact(contactToAdd);
        return mapIntoDto(repository.save(clientToUpdate));
    }


    @Override
    public List<ClientDto> getAllClients() {
        return repository.findAll().stream()
                .map(ClientMapper::mapIntoDto)
                .toList();
    }
}
