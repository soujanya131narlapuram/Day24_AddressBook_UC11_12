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
            System.out.println("4. Get the count of persons by City");
            System.out.println("5. Get the count of persons by State");
            System.out.println("6. Exit");
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
                System.out.print("Enter the city name: ");
                String city = input.nextLine();
                long count = cityDict.get(city) != null ? cityDict.get(city).stream().count() : 0;
                System.out.println("Number of contacts found in city " + city + ": " + count);
            }
            else if(choice == 5) {
                System.out.print("Enter the state name: ");
                String state = input.nextLine();
                long count = stateDict.get(state) != null ? stateDict.get(state).stream().count() : 0;
                System.out.println("Number of contacts found in state " + state + ": " + count);
            }

            else if(choice == 6) {
                break;
            }
        }
        input.close();
    }
}