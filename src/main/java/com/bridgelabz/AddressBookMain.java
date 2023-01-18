package com.bridgelabz;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class AddressBookMain {

    private static HashMap<String, AddressBook> addressBooks;
    private static HashMap<String, ArrayList<ContactPerson>> cityDict;
    private static HashMap<String, ArrayList<ContactPerson>> stateDict;

    public static void main(String[] args) {
        addressBooks = new HashMap<String, AddressBook>();
        cityDict = new HashMap<String, ArrayList<ContactPerson>>();
        stateDict = new HashMap<String, ArrayList<ContactPerson>>();
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("1. Create Address Book");
            System.out.println("2. Add Contact");
            System.out.println("3. View Contacts");
            System.out.println("4. Sort the contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();
            if(choice == 1) {
                System.out.print("Enter address book name: ");
                String addressBookName = input.nextLine();
                AddressBook addressBook = new AddressBook(addressBookName);
                addressBooks.put(addressBookName, addressBook);
                System.out.println("Address book '" + addressBookName + "' created!");
            }
            else if(choice == 2) {
                System.out.print("Enter address book name: ");
                String addressBookName = input.nextLine();
                AddressBook addressBook = addressBooks.get(addressBookName);
                if(addressBook != null) {
                    System.out.print("Enter contact name: ");
                    String name = input.nextLine();
                    System.out.print("Enter contact city: ");
                    String city = input.nextLine();
                    System.out.print("Enter contact state: ");
                    String state = input.nextLine();
                    System.out.print("Enter contact age: ");
                    int age = input.nextInt();
                    input.nextLine();
                    ContactPerson contact = new ContactPerson(name, city, state, age);
                    addressBook.addContact(contact);
                    if(!cityDict.containsKey(city)) {
                    cityDict.put(city, new ArrayList<ContactPerson>());
                }
                cityDict.get(city).add(contact);
                if(!stateDict.containsKey(state)) {
                    stateDict.put(state, new ArrayList<ContactPerson>());
                }
                stateDict.get(state).add(contact);
            }
            else {
                System.out.println("Address book not found!");
            }
        }
            else if(choice == 3) {
                System.out.print("Enter address book name: ");
                String addressBookName = input.nextLine();
                AddressBook addressBook = addressBooks.get(addressBookName);
                if(addressBook != null) {
                    ArrayList<ContactPerson> contacts = addressBook.getContacts();
                    for(ContactPerson contact : contacts) {
                        System.out.println("Name: " + contact.getName());
                        System.out.println("City: " + contact.getCity());
                        System.out.println("State: " + contact.getState());
                        System.out.println("Age: " + contact.getAge());
                    }
                }
                else {
                    System.out.println("Address book not found!");
                }
            }
            else if(choice == 4) {
                System.out.print("Enter address book name: ");
                String addressBookName = input.nextLine();
                AddressBook addressBook = addressBooks.get(addressBookName);
                if(addressBook != null) {
                    addressBook.sortContacts();
                    addressBook.getContacts().forEach(System.out::println);
                }
                else {
                    System.out.println("Address book not found!");
                }
            }
            else if(choice == 5) {
                break;
            }
        }
        input.close();
    }
}