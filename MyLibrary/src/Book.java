import java.time.LocalDate;
import java.util.Objects;

public class Book  implements Comparable<Book>{

    private  String title;

    private  String author;

    private  int isbn;

    private  LocalDate releaseDate;

    public Book(String title, String author, int isbn, LocalDate releaseDate) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException("Title can not be null");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null) {
            throw new IllegalArgumentException("Author can not be null");
        }
        this.author = author;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        if (isbn == 0) {
            throw new IllegalArgumentException("ISBN can not be 0");
        }
        this.isbn = isbn;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }


    @Override
    public int compareTo(Book o) {
        return (this.isbn - o.getIsbn());
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn=" + isbn +
                ", releaseDate=" + releaseDate +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Book book = (Book) o;
//        return isbn == book.isbn && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(releaseDate, book.releaseDate);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(title, author, isbn, releaseDate);
//    }
}
