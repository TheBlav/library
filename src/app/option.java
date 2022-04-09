package app;

import Exceptions.NoSuchOptionException;

public enum option {
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
            return app.option.values()[option]; // jeżeli ktoś podaje w option wartość, to metoda przeszukuje wszystkie
            // wartości pola wyliczeniowego (value) i zwraca stałą jej przypisaną
        }
        catch (ArrayIndexOutOfBoundsException e){
            throw new NoSuchOptionException("Brak opcji o ID: "+option);
        }
         }
}
