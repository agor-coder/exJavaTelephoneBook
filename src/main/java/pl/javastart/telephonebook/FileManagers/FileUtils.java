/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.javastart.telephonebook.FileManagers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import pl.javastart.telephonebook.TeleBook;
import pl.javastart.telephonebook.model.Contact;

/**
 *
 * @author ET4
 */
public class FileUtils {

    private static final String FILE_NAME = "telebook.csv";

    public static void save(TeleBook teleBook) throws IOException {
        try (
                var writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Contact contact : teleBook.getContacts().values()) {
                writer.write(contact.toCsv());
                writer.newLine();
            }
        }

    }

    public static TeleBook read() {
        TeleBook book = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            Map<String, Contact> contacs = reader.lines()
                    .map(line -> line.split(";"))
                    .map(split -> (new Contact(split[0], split[1])))
                    .collect(Collectors.toMap(Contact::getName, Function.identity()));
            book = new TeleBook(new TreeMap<>(contacs));

        } catch (IOException ex) {
            System.out.println("Plik nie istnieje - tworze pustą bazę");
        }
        return book != null ? book : new TeleBook();
    }
}
