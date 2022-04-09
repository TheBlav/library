package io;

import model.Book;
import model.Magazine;
import java.util.Scanner;
import io.ConsolePrinter;

public class dataReader {
    private ConsolePrinter consolePrinter;
    public dataReader(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    private Scanner scanner = new Scanner(System.in);


public Book readAndCreateBook() {
    consolePrinter.printLine("Podaj Tytuł: ");
    String title = scanner.nextLine();
    consolePrinter.printLine("Podaj Autor: ");
    String author = scanner.nextLine();
    consolePrinter.printLine("Podaj Wydawnictwo: ");
    String publisher = scanner.nextLine();
    consolePrinter.printLine("Podaj numer ISBN: ");
    String isbn = scanner.nextLine();
    consolePrinter.printLine("Podaj rok wydania: ");
    int releaseDate = scanner.nextInt();
    scanner.nextLine();
    consolePrinter.printLine("Podaj ilość stron: ");
    int pages = scanner.nextInt();
    scanner.nextLine();
    return  new Book(releaseDate, title,publisher, author, pages,  isbn);
}
public Magazine readAndCreateMagazine() {
    consolePrinter.printLine("Podaj Tytuł: ");
    String title = scanner.nextLine();

    consolePrinter.printLine("Podaj Wydawnictwo: ");
    String publisher = scanner.nextLine();

    consolePrinter.printLine("rok wydania: ");
    int year = scanner.nextInt();
    scanner.nextLine();

    consolePrinter.printLine("Podaj miesiąc wydania: ");
    int month = scanner.nextInt();
    scanner.nextLine();

    consolePrinter.printLine("Podaj dzień wydania: ");
    int day = scanner.nextInt();
    scanner.nextLine();

    consolePrinter.printLine("Podaj język wydania: ");
    String language = scanner.nextLine();

    return  new Magazine(year, title, publisher,  month, day, language);
}




public int getInt(){
    try {
        return scanner.nextInt();       //tutaj w bloku try wrzucamy pobranie danych
    }
    finally {
        scanner.nextLine();  // jeżeli wystąpi błąd, to i tak zostanie wyzerowana wartosć w strumieniu.
    }
}

public void close(){
    scanner.close();
}
}

