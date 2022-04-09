package io;


import model.Book;
import model.Magazine;
import model.Publication;

public class ConsolePrinter {
    public void printBooks(Publication[] publications){
        int countBooks = 0;
        for (Publication publication : publications) {



            if (publication instanceof Book){
                System.out.println(publication);  // nie trzeba dodawać.toString(); ponieważ jest to domyślne w println.
                countBooks++;
            }
        }
        if (countBooks == 0) {
            printLine("Brak książęk w bilbiotece");
        }
    }

    public void printMagazines(Publication[] publications){
        int countMagazines = 0;
        for (Publication publication : publications) {


            if (publication instanceof Magazine){
                System.out.println(publication);
                countMagazines++;
            }
        }

        if (countMagazines == 0){
            printLine("Brak czasopism w bilbiotece");
        }

    }

    public void printLine(String text){
        System.out.println(text);
    }
}
