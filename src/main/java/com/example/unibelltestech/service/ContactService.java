package com.example.unibelltestech.service;

import com.example.unibelltestech.dto.ContactDto;
import com.example.unibelltestech.model.Contact;
import com.example.unibelltestech.model.Contact.ContactType;

import java.util.List;

public interface ContactService {
    Contact createContact(Contact contact);

    List<ContactDto> findAllByClientId(Long clientId);

    List<ContactDto> findAllByClientIdAndType(Long clientId, ContactType type);
}