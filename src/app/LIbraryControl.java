package app;
import io.dataReader;
import model.Library;
import model.Book;
import model.Magazine;


public class LIbraryControl {

    private dataReader dataReader = new dataReader();
    private Library library = new Library();

    public void controlLoop (){
        option option;
        do {
            printOptions();                     // wczytuje wybór z metody printOptions
            option = app.option.createFromInt(dataReader.getInt());       // wczytuje wybór użytkownia metodą getInt z klasy dataReader
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
                    System.out.println("NIe ma takiej opcji");

        }

    }
        while (option != app.option.EXIT);




    }

    private void printMagazines() {
        library.printMagazines();
    }

    private void addMagazine() {
       Magazine magazine = dataReader.readAndCreateMagazine();
        library.addMagazine(magazine);
    }

    private void exit() {
        System.out.println("KOniec programu, papa!");
        dataReader.close();
    }

    private void printBooks() {
        library.printBooks();                      // wczytuje metodę printBooks z klasy library
    }

    private void addBook() {
        Book book = dataReader.readAndCreateBook();              // wczytuje metoreę readAndCreateBook z klasy dataReader
        library.addBook(book);
    }

    private void printOptions() {
        System.out.println("Wybierz opcję: ");
        for (option value : option.values()) {
            System.out.println(value);

        }
    }
}
