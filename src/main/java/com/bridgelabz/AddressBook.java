package com.bridgelabz;
import java.util.ArrayList;
public class AddressBook {
    private ArrayList<ContactPerson> contacts;
    private String name;

    public AddressBook(String name) {
        this.name = name;
        this.contacts = new ArrayList<ContactPerson>();
    }

    public void addContact(ContactPerson contact) {
        if(!contacts.contains(contact)){
            contacts.add(contact);
            System.out.println("Contact added to '" + name + "'!");
        }else{
            System.out.println("Contact already exists in '" + name + "'!");
        }
    }

    public ArrayList<ContactPerson> getContacts() {
        return contacts;
    }

    public String getName() {
        return name;
    }
}

