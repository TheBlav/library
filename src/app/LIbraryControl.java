package app;
import Exceptions.NoSuchOptionException;
import io.dataReader;
import model.Library;
import model.Book;
import model.Magazine;
import io.ConsolePrinter;
import model.Publication;

import java.util.InputMismatchException;
import java.util.Optional;


public class LIbraryControl {
    private ConsolePrinter consolePrinter = new ConsolePrinter();
    private dataReader dataReader = new dataReader(consolePrinter);
    private Library library = new Library();


    public void controlLoop (){
        option option;
        do {
            printOptions();                     // wczytuje wybór z metody printOptions
            option = getOption();       // wczytuje wybór użytkownia metodą getInt z klasy dataReader
            switch (option){
                case ADD_BOOK:
                    addBook();                  //wczytuje metodę Addbook
                    break;

                case ADD_MAGAZINE:              //wczytuje metodę addMagazine
                    addMagazine();
                    break;

                case PRINT_MAGAZINES:           //wczytuje metodę printMagazine,
                    printMagazines();           //metoda nie istniała i została dodana przez skrót alt+enter
                    break;

            case PRINT_BOOKS:

                printBooks();                   // wczytuje metodę printbooks
                break;

            case EXIT:
                exit();                         // wczytuje metodę exit
                break;
                default:
                    consolePrinter.printLine("NIe ma takiej opcji");

        }

    }
        while (option != option.EXIT);




    }

    private option getOption() {
        boolean optionOk = false;
        option option = null;
        while (!optionOk){
            try{
                option = option.createFromInt(dataReader.getInt());
                optionOk = true;
            }
            catch (NoSuchOptionException e){
                consolePrinter.printLine(e.getMessage());
            }
            catch (InputMismatchException e){
                consolePrinter.printLine("Wprowadzona wartość nie jest liczbą.");
            }
        }
        return option;   // stop na 14:40
    }

    private void printMagazines() {
        Publication[] publications = library.getPublications();
        consolePrinter.printMagazines(publications);
    }

    private void addMagazine() {
        try {
            Magazine magazine = dataReader.readAndCreateMagazine();
            library.addMagazine(magazine);
        }
        catch (InputMismatchException e){
            consolePrinter.printLine("Nie udało się utworzyć magazynu");
        }
        catch (ArrayIndexOutOfBoundsException e){
            consolePrinter.printLine("Osiąnięto limit pojemności, nie można dodać magazynu.");
        }
        }


    private void exit() {
        consolePrinter.printLine("KOniec programu, papa!");
        dataReader.close();
    }

    private void printBooks() {
        Publication[] publications = library.getPublications();// wczytuje metodę printBooks z klasy library
        consolePrinter.printBooks(publications);
    }

    private void addBook() {
        try {
            Book book = dataReader.readAndCreateBook();              // wczytuje metoreę readAndCreateBook z klasy dataReader
            library.addBook(book);
        }
        catch (InputMismatchException e){
            consolePrinter.printLine("Nie udało się utworzyć książki");
        }
        catch (ArrayIndexOutOfBoundsException e){
            consolePrinter.printLine("Osiąnięto limit pojemności, nie można dodać książki.");
        }
    }

    private void printOptions() {
        consolePrinter.printLine("Wybierz opcję: ");
        for (option value : option.values()) {
            consolePrinter.printLine(value.toString());     //jawne wywołanie .toString

        }
    }

    private enum option {
        EXIT (0, " - wyjście z programu"),
        ADD_BOOK (1, " - dodanie nowej książki"),
        ADD_MAGAZINE (2, " - dodanie nowego magazynu"),
        PRINT_BOOKS (3, " - wyświetl dostępne książki"),
        PRINT_MAGAZINES (4, " - wyświetl dostępnę magazyny");

        private final int value;
        private final String description;

        option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        public int getValue() {
            return value;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return  value +  " " + description;
        }

        static option createFromInt (int option) throws NoSuchOptionException {
            try {
                return LIbraryControl.option.values()[option]; // jeżeli ktoś podaje w option wartość, to metoda przeszukuje wszystkie
                // wartości pola wyliczeniowego (value) i zwraca stałą jej przypisaną
            }
            catch (ArrayIndexOutOfBoundsException e){
                throw new NoSuchOptionException("Brak opcji o ID: "+option);
            }
        }
    }
}
