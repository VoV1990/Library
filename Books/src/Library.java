public class Library {
    private static Book[] books;

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
            books = new Book[tempBase.length + books.length];
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
}
