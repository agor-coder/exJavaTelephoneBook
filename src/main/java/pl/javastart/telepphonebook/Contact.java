/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.javastart.telepphonebook;

/**
 *
 * @author ET4
 */
public class Contact implements Comparable<Contact> {

    private String name;
    private String number;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public int compareTo(Contact o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name + " : " + number;
    }

}
