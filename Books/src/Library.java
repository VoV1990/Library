import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Library {
    private static Book[] books;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Library(Book... newBooks) {
        cloneArray(newBooks);
    }

    public Book[] getBooks() {
        return books;
    }

    private static void cloneArray(Book[] newBooks) {
        Book[]tempBase = new Book[0];
        if(books != null) {
            tempBase = books;
            books = new Book[tempBase.length + newBooks.length];
        } else books = new Book[newBooks.length];
        int index = 0;
        int index2 = 0;
        for (; index < tempBase.length; index++) {
            books[index] = tempBase[index];
        }
        for (; index2 < newBooks.length; index2++) {
            books[index] = newBooks[index2];
            index++;
        }
    }

    public void chooseOption() throws IOException {
        boolean stop = false;
        int option = 0;
        do{
            System.out.println("Please choose one of the suggested options and enter its number.");
            System.out.println("1. Display a list of books by the specified author.");
            System.out.println("2. Display a list of books published by the specified publisher.");
            System.out.println("3. Display a list of books released after the specified year.");
            try {
                option = Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                System.out.println("Invalid data.");
            }
            if(option == 1 || option == 2 || option == 3) stop = true;
            else System.out.println("Please try again");
        } while (!stop);
        chooseBooks(option);
    }

    private void chooseBooks(int option) throws IOException {
        switch (option) {
            case 1 -> {
                System.out.println("Please enter author name:");
                String author = reader.readLine();
                for (int i = 0; i < this.getBooks().length; i++) {
                    if(this.getBooks()[i].getAuthor().equalsIgnoreCase(author))
                        System.out.println(this.getBooks()[i]);
                }
            }
            case 2 -> {
                System.out.println("Please enter publishing house:");
                String publisher = reader.readLine();
                for (int i = 0; i < this.getBooks().length; i++) {
                    if(this.getBooks()[i].getPublishingHouse().equalsIgnoreCase(publisher))
                        System.out.println(this.getBooks()[i]);
                }
            }
            case 3 -> {
                System.out.println("Please enter the year:");
                int year = Integer.parseInt(reader.readLine());
                for (int i = 0; i < this.getBooks().length; i++) {
                    if(this.getBooks()[i].getPublicationYear() > year)
                        System.out.println(this.getBooks()[i]);
                }
            }
        }
    }
}
