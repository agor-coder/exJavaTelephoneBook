/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.javastart.telephonebook;

import pl.javastart.telephonebook.model.Contact;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author ET4
 */
public class TeleBook {

    private Map<String, Contact> contacts = new TreeMap<>();

    public TeleBook() {
    }

    public TeleBook(Map<String, Contact> contacts) {
        this.contacts = contacts;
    }

    public Map<String, Contact> getContacts() {
        return contacts;
    }
    

    public boolean add(String name, String telephone) {
        if (name == null || telephone == null) {
            throw new NullPointerException("name and telephone can't be null");
        }
        if (name.isEmpty() || telephone.isEmpty()) {
            throw new IllegalArgumentException("name or telephone can't be empty");
        }
        if (!contacts.containsKey(name)) {
            contacts.put(name, new Contact(name, telephone));
            return true;
        }
        return false;
    }

    public boolean remove(String name) {
        return contacts.remove(name) != null;
    }

    public List<Contact> finByName(String name) {
        List<Contact> foundNames = new ArrayList<>();
        for (var entry : contacts.entrySet()) {
            if (entry.getKey().toLowerCase().contains(name.toLowerCase())) {// ignore case
                foundNames.add(entry.getValue());
            }
        }
        return foundNames;
    }
    ///lub
    /*public List<Contact> finByName(String name) {
        List<Contact> findNames = new ArrayList<>();
        for (Contact contact : contacts.values()) {
            if (contact.getNumber().contains(name)) {
                findNames.add(contact);
            }
        }
        return findNames;
    }*/
    
    public List<Contact> finByNumber(String number) {
        List<Contact> foundNumbers = new ArrayList<>();
        for (Contact contact : contacts.values()) {
            if (contact.getNumber().contains(number)) {
                foundNumbers.add(contact);
            }
        }
        return foundNumbers;

    }

    

   
   
    
}
