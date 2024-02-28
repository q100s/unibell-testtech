package com.example.unibelltestech.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ContactType type;
    private String contactValue;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Contact() {
    }

    public Contact(Long id, ContactType type, String contactValue, Client client) {
        this.id = id;
        this.type = type;
        this.contactValue = contactValue;
        this.client = client;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(id, contact.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", type=" + type +
                ", contactValue='" + contactValue + '\'' +
                ", client=" + client +
                '}';
    }

    public enum ContactType {
        PHONE_NUMBER, EMAIL
    }
}