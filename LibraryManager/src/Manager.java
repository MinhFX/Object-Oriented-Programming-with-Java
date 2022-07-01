import java.util.Scanner;

// Chứa hàm main() để điều khiển luồng chính của ứng dụng
public class Manager {
    public static void main(String[] args) {
        BookList bookList = new BookList();
        // Dùng lệnh print để hiển thị thông tin
        System.out.println("Welcome to the online book library!");

        // Dùng vòng lặp để cho phép người dùng lặp lại việc chọn chức năng
        while (true) {
            System.out.println("-----------------------------------");
            System.out.println("1. Enter a new book");
            System.out.println("2. Search a book by book title");
            System.out.println("3. Display books");
            System.out.println("4. Borrow a book by book ID");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            switch (choice) {
                case 1 -> bookList.Add();
                case 2 -> bookList.Search();
                case 3 -> bookList.Display();
                case 4 -> bookList.Borrow();
                case 5 -> bookList.Exit();
                default -> {
                    System.out.println("Error!");
                    System.exit(0);
                }
            }
        }
    }
}
