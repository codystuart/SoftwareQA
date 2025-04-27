package com.stuart.contacts.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.stuart.contacts.*;

class ContactServiceTest {

	private ContactService service;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
    }

    @Test
    public void testAddContact() {
        service.addContact("123", "John", "Doe", "1234567890", "123 Main St");
        Contact contact = service.getContact("123");
        assertNotNull(contact);
        assertEquals("John", contact.getFirstName());
    }

    @Test
    public void testAddDuplicateContact() {
        service.addContact("123", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> 
            service.addContact("123", "Jane", "Smith", "0987654321", "456 Oak Ave"));
    }

    @Test
    public void testDeleteContact() {
        service.addContact("123", "John", "Doe", "1234567890", "123 Main St");
        service.deleteContact("123");
        assertNull(service.getContact("123"));
    }

    @Test
    public void testDeleteNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> 
            service.deleteContact("999"));
    }

    @Test
    public void testUpdateContact() {
        service.addContact("123", "John", "Doe", "1234567890", "123 Main St");
        service.updateContact("123", "Jane", "Smith", "0987654321", "456 Oak Ave");
        Contact contact = service.getContact("123");
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Oak Ave", contact.getAddress());
    }

    @Test
    public void testUpdateNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> 
            service.updateContact("999", "Jane", "Smith", "0987654321", "456 Oak Ave"));
    }

}
