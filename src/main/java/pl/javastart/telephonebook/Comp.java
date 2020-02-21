/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.javastart.telephonebook;

import java.util.Comparator;
import java.util.Locale;
import pl.javastart.telephonebook.model.Contact;

/**
 *
 * @author A
 */
public class Comp implements Comparator<Contact>{

    @Override
    public int compare(Contact p1, Contact p2) {
        return p1.getName().toLowerCase().compareTo(p2.getName().toLowerCase());
    }
}