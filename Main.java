// Main Class untuk pengujian
public class Main {
    public static void main(String[] args) {
        Library library = new Library(5);

        library.addBook(new Book("Pemrograman Java", "Andi"));
        library.addBook(new Book("Struktur Data", "Budi"));
        library.addBook(new Book("Algoritma", "Citra"));

        library.displayBooks();

        Book result = library.searchBook("Struktur Data");
        if (result != null) {
            System.out.println("Buku ditemukan: " + result.getTitle());
        } else {
            System.out.println("Buku tidak ditemukan.");
        }

        library.removeBook("Pemrograman Java");
        library.displayBooks();
    }
}
