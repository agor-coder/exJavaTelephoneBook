/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.javastart.telepphonebook;

import java.util.Scanner;

/**
 *
 * @author ET4
 */
public class TeleBookController {

    private TeleBook teleBook = new TeleBook();
    private Scanner sc = new Scanner(System.in);

    public void loop() {
        showOptions();
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
        sc.nextLine();
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
            case END:
                close();
                break;
        }
    }

    private void delete() {
        System.out.println("Podaj nazwę:");
        String name = sc.nextLine();
        teleBook.remove(name);
    }

    private void searchByNumber() {
        System.out.println("Podaj numer:");
        String number = sc.nextLine();
        teleBook.finByNumber(number);
    }

    private void searchByName() {
        System.out.println("Podaj nazwę:");
        String name = sc.nextLine();
        teleBook.finByName(name);
    }

    private void addContact() {
        System.out.println("Podaj nazwę:");
        String name = sc.nextLine();
        System.out.println("Podaj numer:");
        String number = sc.nextLine();
        teleBook.add(name, number);

    }

    private void close() {
        sc.close();
    }

}
