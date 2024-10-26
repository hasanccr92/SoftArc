package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search by Author");
            System.out.println("4. Search by Year");
            System.out.println("5. List All Books");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter publication year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    library.addBook(new Book(title, author, year));
                    System.out.println("Book added.");
                    break;

                case 2:
                    System.out.print("Enter book title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    author = scanner.nextLine();
                    System.out.print("Enter publication year: ");
                    year = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    library.removeBook(new Book(title, author, year));
                    System.out.println("Book removed.");
                    break;

                case 3:
                    System.out.print("Enter author name: ");
                    author = scanner.nextLine();
                    System.out.println("Books by " + author + ":");
                    library.getBooksByAuthor(author).forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("Enter publication year: ");
                    year = scanner.nextInt();
                    System.out.println("Books published in " + year + ":");
                    library.getBooksByYear(year).forEach(System.out::println);
                    break;

                case 5:
                    System.out.println("All books in the library:");
                    library.getAllBooks().forEach(System.out::println);
                    break;

                case 6:
                    System.out.println("Exiting Library Management System.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
