# Overview

The Library Management System is a simple Java-based console application that allows users to manage a collection of books. Users can add, view, search, update, and delete book records. The system ensures unique book IDs and maintains availability status.

# Features

Add Book: Users can add a new book by providing book ID, title, author, genre, and availability status.

View All Books: Displays all the books currently available in the library.

Search Book: Users can search for a book using its ID or title.

Update Book Details: Allows users to modify the title, author, or availability status of an existing book.

Delete Book Record: Removes a book from the system using its book ID.

Exit: Closes the application.

# Class Descriptions

1. Book Class

Represents a book entity with the following attributes:

bookID: Unique identifier for the book.

title: Title of the book.

author: Author of the book.

genre: Genre/category of the book.

availabilityStatus: Shows whether the book is "Available" or "Checked Out".

2. Library Class

Manages a collection of books and provides the following functionalities:

addBook(Book book): Adds a new book if the book ID is unique.

viewAllBooks(): Displays all books in the library.

searchBook(String searchTerm): Searches for a book by ID or title.

updateBookDetails(String bookID, String newTitle, String newAuthor, String newAvailabilityStatus): Updates book details.

deleteBook(String bookID): Removes a book from the library.

isBookIdUnique(String bookID): Ensures book IDs are unique.

3. LibraryApp Class

Contains the main method and handles user interactions:

Uses a Scanner for input.

Presents a menu-driven interface.

Calls appropriate methods from the Library class based on user choices.

# Usage Instructions

-->  Compile the program using:

# javac LibraryApp.java

-->  Run the program:

# java LibraryApp

Follow on-screen instructions to interact with the system.

Input Validation

Ensures book ID is unique.

Title and author fields cannot be empty.

Availability status must be either "Available" or "Checked Out".

# Example Usage

Library Management System
1. Add Book
2. View All Books
3. Search Book by ID or Title
4. Update Book Details
5. Delete Book Record
6. Exit
Enter your choice: 1
Enter Book ID: B001
Enter Title: The Java Handbook
Enter Author: John Doe
Enter Genre: Programming
Enter Availability Status (Available/Checked Out): Available
Book added successfully.

# Future Enhancements

Implement database storage for book records.

Add user authentication.

Introduce graphical user interface (GUI).

# Author

Deepak Sharma

License

This project is open-source and available for modification and distribution.
