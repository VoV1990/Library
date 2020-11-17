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
        library.chooseOption();
    }
}
