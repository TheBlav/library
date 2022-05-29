package model;

import java.io.Serializable;
import java.util.Arrays;

public class Library implements Serializable {


    private static final int INITIAL_CAPACITY = 1;
    private int publicationsNumber = 0;
    private Publication[] publications = new Publication[INITIAL_CAPACITY];

    public Publication[] getPublications () {
        Publication[] result = new Publication[publicationsNumber];
        for (int i = 0; i < result.length; i++) {
            result[i] = publications[i];

        }
        return result;
    }



        public void addPublication (Publication publication){
        // poniżej funkcja automatycznego powiększania tablicy
            if (publicationsNumber == publications.length) {
                Arrays.copyOf(publications, publications.length * 2);
            }

            publications[publicationsNumber] = publication;
            publicationsNumber++;

        }

        public boolean removePublication(Publication publication){
        final int notFound = -1;
        int found = notFound;
        int i = 0;
        while (i < publicationsNumber && found == notFound){
            if (publication.equals(publications[i])){
                found = i;
            }
            else
                i++;
        }
        /* usuwanie elementów tablicy pobiera: tablicę, indeks kopiowania czyli wszystko w prawo od usuwanego argumentu
              następnie wpisujemy do której tablicy skopiować dane, potem od któego momentu, tutaj od naszego usuwanego żeby
             już na jego miejscu zapisywać dalsze dane, i ilość skopiowanych elementów, czyli ilość elementów - indeks znalezionego
             obiektu - 1 ; ponieważ np, jak mam tablicę 4 elementów i na 2 pozycji usuwamy, to:
             indeks =1 i od 3 - 1 = 2 ale jako że dwa to 3 elementy ale musimy uzupełnić ją do końca więć odejmujemy 1 */
        if (found != notFound){
            System.arraycopy(publications, found+1, publications, found, publications.length - found - 1);
            publicationsNumber--;
            publications[publicationsNumber] = null;
        }
        return found != notFound;
        }




    }