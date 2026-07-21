import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise_6_Library_Management_System {

    static class Book {
        private final String title;
        private final String author;

        Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return "Book{title='" + title + "', author='" + author + "'}";
        }
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Clean Code", "Robert C. Martin"));
        books.add(new Book("The Pragmatic Programmer", "Andrew Hunt"));
        books.add(new Book("Introduction to Algorithms", "Thomas H. Cormen"));

        Map<String, Book> titleIndex = new HashMap<>();
        Map<String, List<Book>> authorIndex = new HashMap<>();

        for (Book book : books) {
            titleIndex.put(book.getTitle().toLowerCase(), book);
            authorIndex.computeIfAbsent(book.getAuthor().toLowerCase(), key -> new ArrayList<>()).add(book);
        }

        System.out.println(titleIndex.get("clean code"));
        System.out.println(authorIndex.get("andrew hunt"));
    }
}