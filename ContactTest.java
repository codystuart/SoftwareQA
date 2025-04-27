package com.stuart.contacts.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.stuart.contacts.*;

class ContactTest {

	@Test
    public void testValidContactCreation() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("123", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    public void testContactIdNull() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    public void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("123", "Johnthisnameistoolong", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    public void testPhoneInvalid() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("123", "John", "Doe", "12345", "123 Main St")); // Too short
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("123", "John", "Doe", "123abc7890", "123 Main St")); // Non-digits
    }

    @Test
    public void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("123", "John", "Doe", "1234567890", "123 Main Street, Apt 45, Building 6"));
    }

    @Test
    public void testUpdateFields() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhoneNumber("0987654321");
        contact.setAddress("456 Oak Ave");
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Oak Ave", contact.getAddress());
    }

}
