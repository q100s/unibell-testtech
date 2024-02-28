package com.example.unibelltestech.service.impl;

import com.example.unibelltestech.dto.ContactDto;
import com.example.unibelltestech.dto.mapper.ContactMapper;
import com.example.unibelltestech.model.Contact;
import com.example.unibelltestech.model.Contact.ContactType;
import com.example.unibelltestech.repository.ContactRepository;
import com.example.unibelltestech.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository repository;

    public ContactServiceImpl(ContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public Contact createContact(Contact contact) {
        return repository.save(contact);
    }

    @Override
    public List<ContactDto> findAllByClientId(Long clientId) {
        return convertIntoDto(repository.findByClientId(clientId));
    }

    @Override
    public List<ContactDto> findAllByClientIdAndType(Long clientId, ContactType type) {
        return convertIntoDto(repository.findByClientIdAndType(clientId, type));
    }

    private List<ContactDto> convertIntoDto(List<Contact> contacts) {
        return contacts.stream()
                .map(ContactMapper::mapIntoDto)
                .toList();
    }
}
