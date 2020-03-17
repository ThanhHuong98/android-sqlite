package com.za.contact.model;

public class Contact {
    String id;

    String name;
    String phone;
    String note;

    public Contact(String name, String phone, String note) {
        this.name = name;
        this.phone = phone;
        this.note = note;
    }

    public Contact(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
