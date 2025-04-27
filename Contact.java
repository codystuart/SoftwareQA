package com.stuart.contacts;

public class Contact {
	private final String contactID; 
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
		
		// Validate the length of contactID and make sure it is 10 or less characters
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("contactID must be less than 10 characters");
		}
		this.contactID = contactID;
		
		// Use the setters for the other variables that are mutable
		setFirstName(firstName);
		setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setAddress(address);
	}
	
	// Getters
    public String getContactId() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }
    
    // Setters and validation against requirements
    public void setFirstName(String firstName) {
    	if (firstName == null || firstName.length() > 10) {
    		throw new IllegalArgumentException("First name must not be null and must be 10 characters or less");
    	}
    	this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
    	if (lastName == null || lastName.length() > 10) {
    		throw new IllegalArgumentException("Last name must not be null and must be 10 characters or less");
    	}
    	this.lastName = lastName;
    }
    
    public void setPhoneNumber(String phoneNumber) {
    	if (phoneNumber == null || phoneNumber.length() != 10) {
    		throw new IllegalArgumentException("Phone number must be exactly 10 characters and is not allowed to be null");
    	}
    	
    	// Loop through phone number string one character at a time to validate it is all numbers
    	for (int i = 0; i < phoneNumber.length(); i++) {
    		if (!Character.isDigit(phoneNumber.charAt(i))) {
    			throw new IllegalArgumentException("Phone number may only be comprised of characters 0-9.");
    		}
    	}
    	this.phoneNumber = phoneNumber;
    }
    
    public void setAddress(String address) {
    	if (address == null || address.length() > 30) {
    		throw new IllegalArgumentException("Address must not be null and must be 30 characters or less");
    	}
    	this.address = address;
    }
}

