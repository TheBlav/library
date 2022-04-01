package io;

import model.Book;
import model.Magazine;
import java.util.Scanner;

public class dataReader {
private Scanner scanner = new Scanner(System.in);

public Book readAndCreateBook() {
    System.out.println("Podaj Tytuł: ");
    String title = scanner.nextLine();
    System.out.println("Podaj Autor: ");
    String author = scanner.nextLine();
    System.out.println("Podaj Wydawnictwo: ");
    String publisher = scanner.nextLine();
    System.out.println("Podaj numer ISBN: ");
    String isbn = scanner.nextLine();
    System.out.println("Podaj rok wydania: ");
    int releaseDate = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Podaj ilość stron: ");
    int pages = scanner.nextInt();
    scanner.nextLine();
    return  new Book(releaseDate, title,publisher, author, pages,  isbn);
}
public Magazine readAndCreateMagazine() {
    System.out.println("Podaj Tytuł: ");
    String title = scanner.nextLine();

    System.out.println("Podaj Wydawnictwo: ");
    String publisher = scanner.nextLine();

    System.out.println("rok wydania: ");
    int year = scanner.nextInt();
    scanner.nextLine();

    System.out.println("Podaj miesiąc wydania: ");
    int month = scanner.nextInt();
    scanner.nextLine();

    System.out.println("Podaj dzień wydania: ");
    int day = scanner.nextInt();
    scanner.nextLine();

    System.out.println("Podaj język wydania: ");
    String language = scanner.nextLine();

    return  new Magazine(year, title, publisher,  month, day, language);
}




public int getInt(){
    int number = scanner.nextInt();
    scanner.nextLine();
    return number;
}

public void close(){
    scanner.close();
}
}

