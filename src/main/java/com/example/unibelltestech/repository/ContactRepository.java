package com.example.unibelltestech.repository;

import com.example.unibelltestech.model.Contact;
import com.example.unibelltestech.model.Contact.ContactType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByClientId(@Param("client_id") Long clientId);

    List<Contact> findByClientIdAndType(@Param("client_id") Long clientId, @Param("type") ContactType type);
}