// Class Library untuk mengelola array buku
class Library {
    private Book[] books;
    private int count;

    public Library(int capacity) {
        books = new Book[capacity];
        count = 0;
    }

    // Menambahkan buku baru
    public void addBook(Book book) {
        if (count < books.length) {
            books[count] = book;
            count++;
            System.out.println("Buku \"" + book.getTitle() + "\" berhasil ditambahkan.");
        } else {
            System.out.println("Perpustakaan penuh, tidak bisa menambahkan buku baru.");
        }
    }

    // Menghapus buku berdasarkan judul
    public void removeBook(String title) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                books[i] = books[count - 1]; // replace dengan buku terakhir
                books[count - 1] = null;
                count--;
                found = true;
                System.out.println("Buku \"" + title + "\" berhasil dihapus.");
                break;
            }
        }
        if (!found) {
            System.out.println("Buku \"" + title + "\" tidak ditemukan.");
        }
    }

    // Mencari buku berdasarkan judul
    public Book searchBook(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    // Menampilkan semua buku
    public void displayBooks() {
        if (count == 0) {
            System.out.println("Tidak ada buku di perpustakaan.");
            return;
        }
        System.out.println("Daftar Buku:");
        for (int i = 0; i < count; i++) {
            System.out.println("- " + books[i].getTitle() + " oleh " + books[i].getAuthor() + 
                (books[i].isAvailable() ? " (Tersedia)" : " (Dipinjam)"));
        }
    }

      // Menampilkan hanya buku yang tersedia
    public void displayAvailableBooks() {
        boolean adaBuku = false;
        for (int i = 0; i < count; i++) {
            if (books[i].isAvailable()) {
                if (!adaBuku) {
                    System.out.println("Buku yang tersedia:");
                    adaBuku = true;
                }
                System.out.println("- " + books[i].getTitle() + " oleh " + books[i].getAuthor());
            }
        }
        if (!adaBuku) {
            System.out.println("Tidak ada buku yang tersedia saat ini.");
        }
    }

    // Meminjam buku
    public void borrowBook(String title) {
        Book book = searchBook(title);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Buku \"" + title + "\" berhasil dipinjam.");
        } else if (book != null) {
            System.out.println("Buku \"" + title + "\" sedang dipinjam.");
        } else {
            System.out.println("Buku \"" + title + "\" tidak ditemukan.");
        }
    }

    // Mengembalikan buku
    public void returnBook(String title) {
        Book book = searchBook(title);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            System.out.println("Buku \"" + title + "\" berhasil dikembalikan.");
        } else if (book != null) {
            System.out.println("Buku \"" + title + "\" sudah tersedia.");
        } else {
            System.out.println("Buku \"" + title + "\" tidak ditemukan.");
        }
    }
}