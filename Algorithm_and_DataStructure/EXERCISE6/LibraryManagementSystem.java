package Algorithm_and_DataStructure.EXERCISE6;

import java.util.Arrays;
import java.util.Comparator;

public class LibraryManagementSystem {

    static class Book {
        int bookId;
        String title;
        String author;

        Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        @Override
        public String toString() {
            return "Book ID: " + bookId +
                    ", Title: " + title +
                    ", Author: " + author;
        }
    }

    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title) {
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int comparison =
                    books[mid].title.compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Book[] books = {
                new Book(101, "Java Programming", "James Gosling"),
                new Book(102, "Data Structures", "Mark Allen"),
                new Book(103, "Operating Systems", "Galvin"),
                new Book(104, "Computer Networks", "Tanenbaum"),
                new Book(105, "Database Systems", "Korth")
        };

        String searchTitle = "Data Structures";

        System.out.println("Linear Search:");

        Book result1 = linearSearch(books, searchTitle);

        if (result1 != null) {
            System.out.println(result1);
        } else {
            System.out.println("Book not found.");
        }

        Arrays.sort(books,
                Comparator.comparing(book -> book.title));

        System.out.println("\nBinary Search:");

        Book result2 = binarySearch(books, searchTitle);

        if (result2 != null) {
            System.out.println(result2);
        } else {
            System.out.println("Book not found.");
        }
    }
}