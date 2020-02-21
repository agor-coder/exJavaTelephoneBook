/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.javastart.telepphonebook;

import java.util.NoSuchElementException;

/**
 *
 * @author ET4
 */
public enum Options {
    ADD_CONTACT(0, "Dodaj kontakt"),
    REMOVE_CONTACT(1, "Usuń kontakt"),
    SEARCH_BY_NAME(2, "Szukaj nazwy"),
    SEARCH_BY_NUMBER(3, "Szukaj numeru"),
    PRINT_CONTACS(4,"Drukuj"),
    END(5, "Koniec");

    private final int number;
    private final String desription;

    private Options(int number, String desription) {
        this.number = number;
        this.desription = desription;
    }

    static Options convertToOption(int number) {
        if (number < 0 || number >= values().length) {
            throw new NoSuchElementException();
        }
        return values()[number];
    }

    @Override
    public String toString() {
        return number + " - " + desription;
    }

}
