import java.util.ArrayList;
import java.util.Scanner;

// Chứa danh sách các cuốn sách và các phương thức xử lý liên quan
public class BookList {
    // Dùng ArrayList để quản lý danh sách
    ArrayList<Book> myBooks = new ArrayList<>();

    // Chức năng 1: Cho phép người dùng nhập thông tin về sách
    public void Add() {
        System.out.println("Enter information for the new book: ");
        Scanner input = new Scanner(System.in);
        System.out.print("ID: ");
        String id = input.nextLine();
        System.out.print("Title: ");
        String title = input.nextLine();
        System.out.print("Author: ");
        String author = input.nextLine();
        System.out.print("Is borrowed (1 = Yes, 0 = No): ");
        int isBorrowed = input.nextInt();
        Book aBook = new Book(id.toUpperCase(), title, author, isBorrowed);
        myBooks.add(aBook);
        System.out.println("A new book has been added.");
    }

    // Chức năng 2: Tìm kiếm sách theo tên sách
    public void Search() {
        System.out.print("Enter book title to search: ");
        Scanner input = new Scanner(System.in);
        String searchKey = input.nextLine();

        for (int i = 0; i < myBooks.size(); i++) {
            if (myBooks.get(i).getTitle().equalsIgnoreCase(searchKey)) {
                System.out.printf("%-10s%-20s%-20s%-20s\n", "ID", "Title", "Author", "Is borrowed");
                myBooks.get(i).displayBooks();
                return;
            }
        }

        System.out.println("No book is found.");
    }

    // Chức năng 3: Hiển thị danh sách đang có trong thư viện
    public void Display() {
        if (myBooks.size() == 0) {
            System.out.println("No book is found.");
        } else {
            System.out.printf("%-10s%-20s%-20s%-20s\n", "ID", "Title", "Author", "Is borrowed");
            for (int i = 0; i < myBooks.size(); i++) {
                myBooks.get(i).displayBooks();
            }
        }
    }

    // Chức năng 4: Cho mượn sách theo ID của cuốn sách
    public void Borrow() {
        System.out.print("Enter book ID to borrow: ");
        Scanner input = new Scanner(System.in);
        String searchKey = input.nextLine();

        for (int i = 0; i < myBooks.size(); i++) {
            if (myBooks.get(i).getId().equalsIgnoreCase(searchKey)) {
                if (myBooks.get(i).getBorrowed().equals("Yes")) {
                    System.out.println("You cannot borrow this book. The book has been borrowed.");
                    return;
                }

                myBooks.get(i).setBorrowed();
                System.out.println("You have successfully borrow the book: " + myBooks.get(i).getTitle());
                return;
            }
        }

        System.out.println("No book is found.");
    }

    // Chức năng 5: Thoát chương trình
    public void Exit() {
        System.exit(0);
    }
}
