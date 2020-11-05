import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        Book book1 = new Book("Harry Potter and the philosopher's stone", "Rowling",
                "Rosman", 2007, 397, 20, "solid");
        Book book2 = new Book("Harry Potter and the chamber of secrets", "Rowling",
                "Rosman", 2007, 472, 20, "solid");
        Book book3 = new Book("Murder on the Orient Express", "Christy",
                "AST", 2002, 221, 15, "soft");
        Book book4 = new Book("Ten little Negroes", "A. Christy",
                "AST", 2003, 285, 14, "solid");
        Book book5 = new Book("Inferno", "Brown",
                "AST", 2016, 543, 25, "solid");
        Library library = new Library(book1, book2, book3, book4, book5);
        chooseOption(library);
    }

    private static void chooseOption(Library library) throws IOException {
        boolean stop = false;
        int option;
        do{
            System.out.println("Please choose one of the suggested options and enter its number.");
            System.out.println("1. Display a list of books by the specified author.");
            System.out.println("2. Display a list of books published by the specified publisher.");
            System.out.println("3. Display a list of books released after the specified year.");
            option = Integer.parseInt(reader.readLine());
            if(option == 1 || option == 2 || option == 3) stop = true;
            else System.out.println("Please try again");
        } while (!stop);
        getBooks(option, library);
    }

    private static void getBooks(int option, Library library) throws IOException {
        switch (option) {
            case 1 -> {
                System.out.println("Please enter author name:");
                String author = reader.readLine();
                for (int i = 0; i < library.getBooks().length; i++) {
                    if(library.getBooks()[i].getAuthor().equalsIgnoreCase(author))
                        System.out.println(library.getBooks()[i]);
                }
            }
            case 2 -> {
                System.out.println("Please enter publishing house:");
                String publisher = reader.readLine();
                for (int i = 0; i < library.getBooks().length; i++) {
                    if(library.getBooks()[i].getPublishingHouse().equalsIgnoreCase(publisher))
                        System.out.println(library.getBooks()[i]);
                }
            }
            case 3 -> {
                System.out.println("Please enter the year:");
                int year = Integer.parseInt(reader.readLine());
                for (int i = 0; i < library.getBooks().length; i++) {
                    if(library.getBooks()[i].getPublicationYear() > year)
                        System.out.println(library.getBooks()[i]);
                }
            }
        }
    }
}
