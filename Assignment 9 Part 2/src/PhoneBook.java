import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {
    // The file from which to read data (change the filename here)
    In in = new In("bigfile1.txt");

    // Keep list of all existing (i.e. not deleted yet) contacts.
    List<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        // start timer
        final long startTime = System.currentTimeMillis();

        // process the queries
        new PhoneBook().processQueries();

        // end the timer and print the result
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime)/1000F + "seconds.");
    }

    void processQueries() {
        int queryCount = in.nextInt();
        for (int i = 0; i < queryCount; ++i)
            processQuery(readQuery());
    }

    // returns a Query object based on the contents of a line
    private Query readQuery() {
        String type = in.next();
        int number = in.nextInt();
        if (type.equals("add")) {
            String name = in.next();
            return new Query(type, name, number);
        } else {
            return new Query(type, number);
        }
    }

    // this is the method you need to change
    private void processQuery(Query query) {
        if (query.type.equals("add")) {
            // if a contact with this number exists,
            // overwrite the contact's name
            boolean wasFound = false;
            for (Contact contact : contacts)
                if (contact.number == query.number) {
                    contact.name = query.name;
                    wasFound = true;
                    break;
                }
            // otherwise, just add it
            if (!wasFound)
                contacts.add(new Contact(query.name, query.number));
        } else if (query.type.equals("del")) {
            for (Iterator<Contact> it = contacts.iterator(); it.hasNext(); )
                if (it.next().number == query.number) {
                    it.remove();
                    break;
                }
        } else {
            String response = "not found";
            for (Contact contact: contacts)
                if (contact.number == query.number) {
                    response = contact.name;
                    break;
                }
            System.out.println(response);
        }
    }

    // Helper classes follow below
    static class Contact {
        String name;
        int number;

        public Contact(String name, int number) {
            this.name = name;
            this.number = number;
        }
    }

    static class Query {
        String type;
        String name;
        int number;

        public Query(String type, String name, int number) {
            this.type = type;
            this.name = name;
            this.number = number;
        }

        public Query(String type, int number) {
            this.type = type;
            this.number = number;
        }
    }

    class In {
        Scanner scanner;

        In(String filename) {
            try {
                scanner = new Scanner(new BufferedInputStream(new FileInputStream(new File("sample1.txt"))));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String next() {
            return scanner.next();
        }

        int nextInt() {
            return scanner.nextInt();
        }
    }
}
