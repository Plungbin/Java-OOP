import java.time.LocalDate;
import java.util.*;

public class LibraryMain {

    public static void main(String[] args) {

        // Books implement not from file, because of simple example.

        Book b1 = new Book("Ogniem i Mieczem", "Henryk Sienkiewicz", 12345, LocalDate.of(1998, 4, 24));
        Book b2 = new Book("Pan Tadeusz", "Adam Mickiewicz", 54321, LocalDate.of(2004, 6, 5));
        Book b3 = new Book("Balladyna", "Juliusz Słowacki", 54311, LocalDate.of(1995, 10, 25));
        Book b4 = new Book("W Pustyni i w Puszczy", "Henryk Sienkiewicz", 433222, LocalDate.of(2009, 8, 15));
        Book b5 = new Book("Dziady", "Adam Mickiewicz", 5434321, LocalDate.of(2020, 5, 23));
        Book b6 = new Book("Lokomotywa", "Jan Brzechwa", 54341111, LocalDate.of(2004, 4, 30));


        Set<Book> bookListInTreeSet = new TreeSet<>();
        bookListInTreeSet.add(b1);
        bookListInTreeSet.add(b2);
        bookListInTreeSet.add(b3);
        bookListInTreeSet.add(b4);
        bookListInTreeSet.add(b5);
        bookListInTreeSet.add(b6);


        //**************************************************************************************

        Scanner in = new Scanner(System.in);
        int chosenNumber;

        do {
            System.out.println("Menu");
            System.out.println("1 - Wyjście");
            System.out.println("2 - Dodaj ksiazke");
            System.out.println("3 - Szukaj ksiazki po tytule");
            System.out.println("4 - Szukaj ksiązki po autorze");
            System.out.println("5 - Wyszukaj książkę o podanym numerze ISBN");
            System.out.println("6 - Posortuj ksiazki wedlug numeru ISBN");
            System.out.println("7 - Wyswietl tytuł i autora ksiazek posortowanych według daty wydania ");
            System.out.println("8 - Wyświetl ilość książek wydanych po podanym roku");


            System.out.print("Podaj numer z menu: ");


            chosenNumber = in.nextInt();
            in.nextLine();


            if (chosenNumber == 2) {

                System.out.println("Podaj dane książki: ");

                System.out.print("Podaj tutuł: ");
                String title = in.nextLine();

                System.out.print("Podaj autora: ");
                String author = in.nextLine();

                System.out.print("Nadaj numer ISBN: ");
                int isbn = in.nextInt();

                System.out.print("Podaj datę wydania [YYYY-MM-DD]: ");
                LocalDate releaseDate = LocalDate.parse(in.next());

                Book book = addNewBook(title, author, isbn, releaseDate);
                bookListInTreeSet.add(book);

                System.out.println("Dodano nową książkę");


            } else if (chosenNumber == 3) {

                System.out.print("Podaj szukany tytuł: ");

                findBooksForGivenTitle(bookListInTreeSet, in.nextLine());

            } else if (chosenNumber == 4) {

                System.out.print("Podaj autora: ");

                findBooksForGivenAuthor(bookListInTreeSet, in.nextLine());


            } else if (chosenNumber == 5) {

                System.out.print("Podaj numer ISBN: ");
                System.out.println(findBooksForGivenISBN(bookListInTreeSet, in.nextInt()));

            } else if (chosenNumber == 6) {

                sortBooksByISBN(bookListInTreeSet);

            } else if (chosenNumber == 7) {

                printBooksTitlesAndAuthorsSortedByReleseDate(bookListInTreeSet);

            } else if (chosenNumber == 8) {

                System.out.print("Podaj rok wydania: ");

                printCountOfBooksWhereReleseDateIsAfterGivenYear(bookListInTreeSet, in.nextInt());
            }
        }while (chosenNumber != 1);

    }


        private static Book addNewBook (String title, String author,int isbn, LocalDate releaseDate){

            Book book = new Book(title, author, isbn, releaseDate);
            return book;

        }


        private static void findBooksForGivenTitle (Set < Book > bookListInTreeSet, String title){

            bookListInTreeSet.stream()
                    .filter(book -> book.getTitle().equals(title))
                    .sorted(Comparator.comparing(Book::getAuthor))
                    .forEach(System.out::println);

        }

        private static void findBooksForGivenAuthor (Set < Book > bookListInTreeSet, String author){

            bookListInTreeSet.stream()
                    .filter(book -> book.getAuthor().equals(author))
                    .sorted(Comparator.comparing(Book::getTitle))
                    .forEach(System.out::println);

        }

        private static Optional<Book> findBooksForGivenISBN (Set < Book > bookListInTreeSet, int isbn){

            Optional<Book> bookToRemove = bookListInTreeSet.stream()
                    .filter(book -> book.getIsbn() == isbn)
                    .findFirst();
            return (bookToRemove);
        }
        private static void printBooksTitlesAndAuthorsSortedByReleseDate (Set < Book > bookListInTreeSet) {

            bookListInTreeSet.stream()

                    .sorted(Comparator.comparing(Book::getReleaseDate))
                    .map(b -> b.getTitle() + " - " + b.getAuthor())
                    .forEach(System.out::println);

        }

        private static void sortBooksByISBN (Set < Book > bookListInTreeSet) {

            for (Book b : bookListInTreeSet) {
                System.out.println(b);
            }

        }

        private static void printCountOfBooksWhereReleseDateIsAfterGivenYear (Set < Book > bookListInTreeSet,int year){

            long count = bookListInTreeSet.stream()
                    .filter(book -> book.getReleaseDate().getYear() > year)
                    .count();
            System.out.println("Są " + count + " książki wydane po  " + year + " roku");
        }
        private static Optional<Book> removeBookByIsbn (Set < Book > bookListInTreeSet,int isbn){

            Optional<Book> bookToRemove = bookListInTreeSet.stream()
                    .filter(book -> book.getIsbn() == isbn)
                    .findFirst();

            return (bookToRemove);
        }


    }




