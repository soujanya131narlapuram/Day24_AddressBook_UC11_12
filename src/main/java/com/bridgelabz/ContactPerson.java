package com.bridgelabz;

public class ContactPerson {
    private String name;
    private String city;
    private String state;
    private int age;

    public ContactPerson(String name, String city, String state, int age) {
        this.name = name;
        this.city = city;
        this.state = state;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof ContactPerson)) return false;
        ContactPerson contact = (ContactPerson) obj;
        return this.name.equals(contact.name);
    }
}
