import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String bookID;
    private String title;
    private String author;
    private String genre;
    private String availabilityStatus;

    public Book(String bookID, String title, String author, String genre, String availabilityStatus) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availabilityStatus = availabilityStatus;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
        }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookID + ", Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Availability: " + availabilityStatus;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (findBook(book.getBookID()) == null) {
            this.books.add(book);
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Book with this ID already exists.");
        }
    }

    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public Book findBook(String id) {
        for (Book book : books) {
            if (book.getBookID().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public void searchBook(String query) {
        boolean found = false;
        for (Book book : books) {
            if (book.getBookID().equals(query) || book.getTitle().equalsIgnoreCase(query)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }

    public void updateBookDetails(String bookID, String newTitle, String newAuthor, String newGenre, String newAvailabilityStatus) {
        Book book = findBook(bookID);
        if (book != null) {
            book.setTitle(newTitle);
            book.setAuthor(newAuthor);
            book.setGenre(newGenre);
            book.setAvailabilityStatus(newAvailabilityStatus);
            System.out.println("Book details updated successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void deleteBook(String bookID) {
        Book book = findBook(bookID);
        if (book != null) {
            books.remove(book);
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }
}

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by ID or Title");
            System.out.println("4. Update Book Details");
            System.out.println("5. Delete a Book Record");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Book ID: ");
                    String bookID = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter Availability Status (Available/Checked Out): ");
                    String availabilityStatus = scanner.nextLine();
                    if (title.isEmpty() || author.isEmpty() || (!availabilityStatus.equals("Available") && !availabilityStatus.equals("Checked Out"))) {
                        System.out.println("Invalid input. Title and Author cannot be empty, and availability must be 'Available' or 'Checked Out'.");
                    } else {
                        library.addBook(new Book(bookID, title, author, genre, availabilityStatus));
                    }
                    break;
                case "2":
                    library.viewAllBooks();
                    break;
                case "3":
                    System.out.print("Enter Book ID or Title to search: ");
                    String query = scanner.nextLine();
                    library.searchBook(query);
                    break;
                case "4":
                    System.out.print("Enter Book ID to update: ");
                    String idToUpdate = scanner.nextLine();
                    System.out.print("Enter new Title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new Author: ");
                    String newAuthor = scanner.nextLine();
                     System.out.print("Enter new Genre: ");
                    String newGenre = scanner.nextLine();
                    System.out.print("Enter new Availability Status (Available/Checked Out): ");
                    String newAvailabilityStatus = scanner.nextLine();
                   if (newTitle.isEmpty() || newAuthor.isEmpty() || (!newAvailabilityStatus.equals("Available") && !newAvailabilityStatus.equals("Checked Out"))) {
                        System.out.println("Invalid input. Title and Author cannot be empty, and availability must be 'Available' or 'Checked Out'.");
                    } else {
                    library.updateBookDetails(idToUpdate, newTitle, newAuthor, newGenre, newAvailabilityStatus);
                    }
                    break;
                case "5":
                    System.out.print("Enter Book ID to delete: ");
                    String idToDelete = scanner.nextLine();
                    library.deleteBook(idToDelete);
                    break;
                case "6":
                    System.out.println("Exiting Library System. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}