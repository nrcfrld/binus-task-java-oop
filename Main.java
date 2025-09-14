// Main Class untuk pengujian
public class Main {
    public static void main(String[] args) {
        Library library = new Library(5);

        library.addBook(new Book("Pemrograman Java", "Andi"));
        library.addBook(new Book("Struktur Data", "Budi"));
        library.addBook(new Book("Algoritma", "Citra"));

        library.displayAvailableBooks();

        library.borrowBook("Struktur Data");
        library.displayAvailableBooks();

        library.returnBook("Struktur Data");
        library.displayAvailableBooks();
    }
}
