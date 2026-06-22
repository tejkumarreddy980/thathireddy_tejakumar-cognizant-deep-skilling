import java.util.Arrays;
import java.util.Comparator;

public class LibraryManagementSystem {

    static class Book {
        int bookId;
        String title;
        String author;

        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        public String toString() {
            return "ID: " + bookId + ", Title: " + title + ", Author: " + author;
        }
    }

    public static void linearSearch(Book[] books, String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                System.out.println("Book found (Linear Search): " + book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book not found (Linear Search).");
        }
    }

    public static void binarySearch(Book[] books, String title) {
        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));

        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = title.compareToIgnoreCase(books[mid].title);
            if (cmp == 0) {
                System.out.println("Book found (Binary Search): " + books[mid]);
                return;
            } else if (cmp < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println("Book not found (Binary Search).");
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(101, "The Alchemist", "Paulo Coelho"),
            new Book(102, "Atomic Habits", "James Clear"),
            new Book(103, "Clean Code", "Robert C. Martin"),
            new Book(104, "Thinking Fast and Slow", "Daniel Kahneman"),
            new Book(105, "The Power of Habit", "Charles Duhigg")
        };

        System.out.println("Linear Search for 'Clean Code':");
        linearSearch(books, "Clean Code");

        System.out.println("\nBinary Search for 'Atomic Habits':");
        binarySearch(books, "Atomic Habits");
    }
}
