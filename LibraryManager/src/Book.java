// Định nghĩa thuộc tính và phương thức cho các cuốn sách
public class Book {
    private final String id;
    private final String title;
    private final String author;
    private String isBorrowed;

    public Book(String id, String title, String author, int isBorrowed) {
        this.id = id;
        this.title = title;
        this.author = author;

        if (isBorrowed == 1) {
            this.isBorrowed = "Yes";
        } else if (isBorrowed == 0) {
            this.isBorrowed = "No";
        } else {
            System.out.println("Error!");
            System.exit(0);
        }
    }

    public String getTitle() {
        return title;
    }

    public void displayBooks() {
        System.out.printf("%-10s%-20s%-20s%-20s\n", id, title, author, isBorrowed);
    }

    public String getId() {
        return id;
    }

    public void setBorrowed() {
        isBorrowed = "No";
    }

    public String getBorrowed() {
        return isBorrowed;
    }
}
