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
            System.out.println("Contact already exists in the '" + name + "'!");
        }
    }

    public ArrayList<ContactPerson> getContacts() {
        return contacts;
    }

    public String getName() {
        return name;
    }
    public void sortContacts() {
        contacts.sort((c1, c2) -> c1.getName().compareTo(c2.getName()));
    }
    public void sortContactsByCity() {
        contacts.sort((c1, c2) -> c1.getCity().compareTo(c2.getCity()));
    }
    public void sortContactsByState() {
        contacts.sort((c1, c2) -> c1.getState().compareTo(c2.getState()));
    }
}

