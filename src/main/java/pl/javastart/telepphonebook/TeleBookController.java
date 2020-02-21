/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.javastart.telepphonebook;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author ET4
 */
public class TeleBookController {

    private TeleBook teleBook = new TeleBook();
    private Scanner sc = new Scanner(System.in);

    public void loop() {
        Options option = null;
        do {
            try {
                showOptions();
                option = chooseOption();
                sc.nextLine();
                executeOption(option);
            } catch (NoSuchElementException ex) {
                System.out.println("nie ma takiej opcji - jeszcze raz");
                sc.nextLine();
            }
        } while (option != Options.END);
    }

    private void showOptions() {
        System.out.println("Ksiązka telefoniczna:");
        for (Options option : Options.values()) {
            System.out.println(option);
        }
    }

    private Options chooseOption() {
        System.out.println("Wybierz numer:");
        int number = sc.nextInt();
       // sc.nextLine();
        return Options.convertToOption(number);
    }

    private void executeOption(Options option) {
        switch (option) {
            case ADD_CONTACT:
                addContact();
                break;
            case REMOVE_CONTACT:
                delete();
                break;
            case SEARCH_BY_NAME:
                searchByName();
                break;
            case SEARCH_BY_NUMBER:
                searchByNumber();
                break;
            case PRINT_CONTACS:
                printBook();
                break;
            case END:
                close();
                break;
        }
    }

    private void delete() {
        System.out.println("Podaj nazwę:");
        String name = sc.nextLine();
        boolean removed = teleBook.remove(name);
        if (removed) {
            System.out.println("Usunięto " + name);
        } else {
            System.out.println("nie ma takiego");
        }
    }

    private void searchByNumber() {
        System.out.println("Podaj numer:");
        String number = sc.nextLine();
        List<Contact> found = teleBook.finByNumber(number);
        if (!found.isEmpty()) {
            found.forEach(System.out::println);
        } else {
            System.out.println("brak wyników wyszukiwania numbers");
        }
    }

    private void searchByName() {
        System.out.println("Podaj nazwę:");
        String name = sc.nextLine();
        List<Contact> found = teleBook.finByName(name);
        if (!found.isEmpty()) {
            found.forEach(System.out::println);
        } else {
            System.out.println("brak wyników wyszukiwania names");
        }
    }

    private void addContact() {
        try {
            System.out.println("Podaj nazwę:");
            String name = sc.nextLine();
            System.out.println("Podaj numer:");
            String number = sc.nextLine();
            boolean add = teleBook.add(name, number);
            if (add) {
                System.out.println("Dodano " + name);
            } else {
                System.out.println("nie dodano - wpis istnieje");
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void close() {
        System.out.println("Koniec programu");
        sc.close();
    }

    private void printBook() {
        //teleBook.getContacts().entrySet().forEach(System.out::println);
        teleBook.getContacts().values().forEach(System.out::println);
       
        
    }

}
